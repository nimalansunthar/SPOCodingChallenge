package com.spo.codingchallenge.dto;

import java.util.List;
import java.util.Map;

public class OptimisedStaffDTO {
	
	private List<Map<String, Integer>> optStaff;

	public OptimisedStaffDTO(List<Map<String, Integer>> optStaff) {
		super();
		this.optStaff = optStaff;
	}

	public List<Map<String, Integer>> getOptStaff() {
		return optStaff;
	}

	public void setOptStaff(List<Map<String, Integer>> optStaff) {
		this.optStaff = optStaff;
	}	
}
