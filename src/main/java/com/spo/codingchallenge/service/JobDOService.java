package com.spo.codingchallenge.service;

import java.util.List;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.exceptions.EntityNotFoundException;
/**
 * JobDO interface so that we can add different implementations in the future
 * @author ex1
 *
 */
public interface JobDOService {
	
	public JobDO addJob(JobDO job) ;
	public List<JobDO> findAll();
	public JobDO findOne(Long id) throws EntityNotFoundException;
	public void delete(Long id);
}
