package com.maan.vehicle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.maan.vehicle.bean.MClaim;
import com.maan.vehicle.dto.ListViewParam;
import com.maan.vehicle.response.Response;
import com.maan.vehicle.response.ResponseGenerator;
import com.maan.vehicle.response.TransactionContext;
import com.maan.vehicle.service.MClaimService;
import com.maan.vehicle.service.MessagePropertyService;
import com.maan.vehicle.util.ValidationUtil;
import com.maan.vehicle.validator.Convention;
import com.maan.vehicle.validator.MClaimValidator;
import com.maan.vehicle.validator.ValidationResult;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;

@RestController
public class MClaimController {

	@Autowired
	private MClaimService claimService;
	@Autowired
	private @NonNull ResponseGenerator responseGenerator;
	
	@Autowired
	private MessagePropertyService messageSource;
	private @NonNull MClaimValidator validatorService;
	private Convention sorting;

	private static final Logger logger = Logger.getLogger(MClaimController.class);

	//private @NonNull ResponseGenerator responseGenerator;
	
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(@ApiParam(value = "Request payload") @RequestBody MClaim request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		ValidationResult validationResult = validatorService.validate(request);

		claimService.saveorupdate((MClaim) validationResult.getObject());

		try {
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@ApiOperation(value = "Allows to fetch all data List.", response = Response.class)
	@GetMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<MClaim> lst = claimService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		Pageable paging = sorting.getPaging(request.getOrderBy(), sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		try {

			List<MClaim> obj = new ArrayList<MClaim>();
			Page<MClaim> list = null;

			if (ValidationUtil.isEmptyStringArray(request.getOrderBy()) && ValidationUtil.isNull(request.getSearch())) {

				list = claimService.findAll(paging);

			}
			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& ValidationUtil.isNull(request.getSearch())) {

				list = claimService.findAll(paging);

			}
			if (ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = claimService.findSearch(request.getSearch(), paging);

			}

			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = claimService.findSearch(request.getSearch(), paging);

			}

			obj = list.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("data", obj);
			response.put("currentPage", list.getNumber());
			response.put("totalItems", list.getTotalElements());
			response.put("totalPages", list.getTotalPages());

			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (

		Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
}
