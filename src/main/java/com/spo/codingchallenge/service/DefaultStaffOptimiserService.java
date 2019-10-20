package com.spo.codingchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.util.StaffOptimiser;
import com.spo.codingchallenge.value_objects.OptimisedStaff;
/**
 * Staff optimiser service default implementation. We can add additional business logic if we have any.
 * @author ex1
 *
 */
@Service
public class DefaultStaffOptimiserService implements StaffOptimiserService{

	@Autowired
	StaffOptimiser staffOptimiser;
	
	@Override
	public List<OptimisedStaff> optimiseStaffForJob(JobDO job) {		
				
		return staffOptimiser.optimiseStaffForJob(job);
	}

}
