package com.spo.codingchallenge.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.value_objects.OptimisedStaff;


public class DefaultStaffOptimiserTest {

	@InjectMocks
	DefaultStaffOptimiser staffOptimiser;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testOptimiseStaffForJob() {

		List<Integer> rooms = Arrays.asList(35, 21, 17, 28);
		JobDO job1 = new JobDO(rooms, 10, 6);

		OptimisedStaff optStaff = new OptimisedStaff(1, 3, 1, 35);
		OptimisedStaff optStaff1 = new OptimisedStaff(1, 1, 2, 21);
		OptimisedStaff optStaff2 = new OptimisedStaff(3, 2, 0, 17);
		OptimisedStaff optStaff3 = new OptimisedStaff(0, 1, 3, 28);

		List<OptimisedStaff> staffList = Arrays.asList(optStaff, optStaff1, optStaff2, optStaff3);		

		assertEquals(staffList, staffOptimiser.optimiseStaffForJob(job1), "The results not matching!");
	}
	
	
	@Test
	void testForHighcapacityDifference() {

		List<Integer> rooms = Arrays.asList(35, 21, 17, 28);
		JobDO job1 = new JobDO(rooms, 10, 1);

		OptimisedStaff optStaff = new OptimisedStaff(0, 3, 5, 35);
		OptimisedStaff optStaff1 = new OptimisedStaff(0, 2, 1, 21);
		OptimisedStaff optStaff2 = new OptimisedStaff(0, 1, 7, 17);
		OptimisedStaff optStaff3 = new OptimisedStaff(0, 2, 8, 28);

		List<OptimisedStaff> staffList = Arrays.asList(optStaff, optStaff1, optStaff2, optStaff3);		

		assertEquals(staffList, staffOptimiser.optimiseStaffForJob(job1), "The results not matching!");
	}

	
	@Test
	void testForLowcapacityDifference() {

		List<Integer> rooms = Arrays.asList(35, 21, 17, 28);
		JobDO job1 = new JobDO(rooms, 12, 11);

		OptimisedStaff optStaff = new OptimisedStaff(0, 2, 1, 35);
		OptimisedStaff optStaff1 = new OptimisedStaff(2, 1, 1, 21);
		OptimisedStaff optStaff2 = new OptimisedStaff(6, 1, 1, 17);
		OptimisedStaff optStaff3 = new OptimisedStaff(6, 1, 2, 28);

		List<OptimisedStaff> staffList = Arrays.asList(optStaff, optStaff1, optStaff2, optStaff3);		

		assertEquals(staffList, staffOptimiser.optimiseStaffForJob(job1), "The results not matching!");
	}

}
