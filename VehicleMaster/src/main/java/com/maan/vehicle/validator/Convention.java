package com.maan.vehicle.validator;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.maan.vehicle.util.ValidationUtil;



@Service
@Transactional
public class Convention {

	public Direction getSortDirection(String direction) {

		if (direction.equals("asc")) {
			return Sort.Direction.ASC;
		} else if (direction.equals("desc")) {
			return Sort.Direction.DESC;
		}

		return Sort.Direction.ASC;
	}

	public Pageable getPaging(String[] order, int pageNo, int pageSize) {

		List<Order> orders = new ArrayList<Order>();

		if (!ValidationUtil.isEmptyStringArray(order)) {
			if (order[0].contains(",")) {
				// will sort more than 2 fields
				// sortOrder="field, direction"
				for (String sortOrder : order) {
					String[] sort = sortOrder.split(",");
					orders.add(new Order(getSortDirection(sort[1]), sort[0]));

				}
			} else {
				// sort=[field, direction]
				orders.add(new Order(getSortDirection(order[1]), order[0]));

			}

			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(orders));

			return paging;
		} else {
			Pageable paging = PageRequest.of(pageNo, pageSize);

			return paging;
		}

	}

	public int getPageNumber(int pageNo) {

		if (ValidationUtil.isNull(pageNo)) {
			return 0;
		} else {
			return pageNo - 1;
		}

	}

	public int getPageSize(int pageSize) {

		if (ValidationUtil.isNull(pageSize)) {
			return 10000;
		} else {
			return pageSize;
		}

	}

}
