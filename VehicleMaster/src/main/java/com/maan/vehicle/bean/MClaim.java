package com.maan.vehicle.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DynamicInsert
@DynamicUpdate
@Entity
@Builder
@Table(name = "M_CLAIM")
public class MClaim {
	
	@Id
	private BigDecimal cRegNo;
	private BigDecimal cChassisNum;
	private String cPolicyType;
	private String cMake ;
	private String cModel;
	private String cmanufacYear;
	private BigDecimal cLicenseNo;
    private String cInsuraCom;
    private Date cPolicyRegDate;
    private Date cPolicyStartDate;
    private Date cInsureEndDate;

}
