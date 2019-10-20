package com.spo.codingchallenge.util;

import java.util.List;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.value_objects.OptimisedStaff;

/**
 * StaffOptimiser interface so that we can add different implementations in the future
 * @author ex1
 *
 */
public interface StaffOptimiser {

	List<OptimisedStaff> optimiseStaffForJob(JobDO jobDO);
}
