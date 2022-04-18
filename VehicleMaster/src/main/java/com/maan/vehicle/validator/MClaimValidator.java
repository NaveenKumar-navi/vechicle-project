package com.maan.vehicle.validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maan.vehicle.bean.MClaim;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor_ = { @Autowired })
public class MClaimValidator {

	public ValidationResult validate(MClaim request) {
		
		return null;
	}

}
