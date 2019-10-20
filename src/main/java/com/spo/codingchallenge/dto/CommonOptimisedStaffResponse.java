package com.spo.codingchallenge.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class to transfer complex objects
 * @author ex1
 *
 */

public class CommonOptimisedStaffResponse {

	@JsonProperty("STATUS")
	private String status;

	@JsonProperty("MESSAGE")
	private String message;

	@JsonProperty("DATA")
	private List<Map<String, Integer>> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Map<String, Integer>> getData() {
		return data;
	}

	public void setData(List<Map<String, Integer>> data) {
		this.data = data;
	}
}
