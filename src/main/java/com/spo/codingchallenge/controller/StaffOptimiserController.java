package com.spo.codingchallenge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.object_mapper.OptimisedStaffDTOMapper;
import com.spo.codingchallenge.service.StaffOptimiserService;
import com.spo.codingchallenge.util.Util;

/**
 * Staff optimiser end point.
 * @author ex1
 *
 */
@RestController
@RequestMapping(value = "v1/staffoptimiser")
public class StaffOptimiserController {
	
	@Autowired
	StaffOptimiserService optimiserService;	
	
	private static final Logger logger = LoggerFactory.getLogger(StaffOptimiserController.class);
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> optimiseStaff(@Valid @RequestBody JobDO job) {		
		
		logger.info("{} -> {}" ,this.getClass().getSimpleName(), Util.STATUS_START);		
		
		Map<String,Object> response = new HashMap<>();	
		
		List<Map<String, Integer>> result = OptimisedStaffDTOMapper.mapToDTO(optimiserService.optimiseStaffForJob(job));	
		response.put("DATA", result);
		response.put("STATUS", HttpStatus.OK);
		response.put("MESSAGE", "SUCCESS");
		
		logger.info("{} -> {}" ,this.getClass().getSimpleName(), Util.STATUS_SUCCESS);
		
		return response;
	}

}
