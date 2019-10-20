package com.spo.codingchallenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.exceptions.EntityNotFoundException;
import com.spo.codingchallenge.service.JobDOService;


/**
 * All operations with a job will be routed by this controller.
 * @author ex1
 *
 */
@RestController
@RequestMapping(value = "v1/jobs")
public class JobDOController { 
	
	@Autowired
	JobDOService service;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public JobDO addJob(@Valid @RequestBody JobDO job)  {		
		return service.addJob(job);
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping
	public List<JobDO> findAll(){		
		return service.findAll();
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping(value = "/{id}")
	public JobDO findOne(@PathVariable Long id) throws EntityNotFoundException{		
		return service.findOne(id);
	}

}
