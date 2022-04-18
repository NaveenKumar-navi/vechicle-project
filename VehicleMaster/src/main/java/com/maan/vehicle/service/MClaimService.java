package com.maan.vehicle.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maan.vehicle.bean.MClaim;

public interface MClaimService {

	Page<MClaim> findSearch(String search, Pageable paging);

	Page<MClaim> findAll(Pageable paging);

	List<MClaim> getAll();

	void saveorupdate(MClaim object);

}
