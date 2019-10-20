package com.spo.codingchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.exceptions.EntityNotFoundException;
import com.spo.codingchallenge.repositoy.JobDORepository;

/**
 * default implementation of JobDO service to encapsulate the link between DAO
 * and controller and to have business logic if required for some job specific
 * things.
 * 
 * @author ex1
 *
 */
@Service
public class DefaultJobDOService implements JobDOService {

	@Autowired
	JobDORepository jobRepo;
	
	@Override
	public JobDO addJob(JobDO job)  {		
		return jobRepo.save(job);
	}

	@Override
	public List<JobDO> findAll() {
		return jobRepo.findAll();
	}

	@Override
	public JobDO findOne(Long id) throws EntityNotFoundException {

		return jobRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}	

}
