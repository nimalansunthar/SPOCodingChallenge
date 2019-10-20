package com.spo.codingchallenge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.value_objects.OptimisedStaff;

/**
 * StaffOptimiserService interface so that we can add different implementations in the future
 * @author ex1
 *
 */
@Service
public interface StaffOptimiserService {
	
	List<OptimisedStaff> optimiseStaffForJob(JobDO job);

}
