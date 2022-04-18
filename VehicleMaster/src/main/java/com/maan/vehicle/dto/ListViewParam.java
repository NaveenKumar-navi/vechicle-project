package com.maan.vehicle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListViewParam {

	private String search;
	private String orderBy[];
	private int pageSize;
	private int pageNumber;
	private String code[];

}
