package com.maan.vehicle.service.impl;

import java.util.Collections;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.vehicle.bean.MClaim;
import com.maan.vehicle.repository.MClaimRepository;
import com.maan.vehicle.service.MClaimService;


@Service
@Transactional
public class MClaimServiceImpl implements MClaimService{

	@Autowired
	private MClaimRepository repository;
	
	private Logger log = LogManager.getLogger(MClaimServiceImpl.class);
	
	@Override
	public Page<MClaim> findSearch(String search, Pageable paging) {
		String sear = "%" + search + "%";

		return repository.findAll(sear, paging);
	}

	@Override
	public Page<MClaim> findAll(Pageable paging) {
		
		return repository.findAll(paging);
	}

	@Override
	public List<MClaim> getAll() {
		List<MClaim> lst;

		try {
			lst = repository.findAll();

		} catch (Exception ex) {
			log.error(ex);
			return Collections.emptyList();
		}
		return lst;
	}

	@Override
	public void saveorupdate(MClaim object) {
		
		repository.saveAndFlush(object);
	}
}
