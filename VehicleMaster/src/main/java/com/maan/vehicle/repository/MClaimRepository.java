package com.maan.vehicle.repository;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maan.vehicle.bean.MClaim;

public interface MClaimRepository extends JpaRepository<MClaim, BigDecimal>, JpaSpecificationExecutor<MClaim> {

	
	@Query(value = "select * from MCLAIM where upper(concat(C_REGNO,C_CHASSISNUM)) like upper(:search)", nativeQuery = true)
	//Page<MAffinityCodes> findAll(@Param("search") String search, Pageable paging);
	Page<MClaim> findAll(@Param("search")String sear, Pageable paging);

	

}
