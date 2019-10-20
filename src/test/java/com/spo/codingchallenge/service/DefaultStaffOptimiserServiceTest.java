package com.spo.codingchallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.util.DefaultStaffOptimiser;
import com.spo.codingchallenge.value_objects.OptimisedStaff;


public class DefaultStaffOptimiserServiceTest {

	@InjectMocks
	DefaultStaffOptimiserService optimiserService;
	
	@Mock
	DefaultStaffOptimiser staffOptimiser;
	
	
	@BeforeEach
    void setUp() throws Exception
    {
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
		
		List<OptimisedStaff> staffList = Arrays.asList(optStaff,optStaff1,optStaff2,optStaff3);		
		
		when(staffOptimiser.optimiseStaffForJob(Mockito.any(JobDO.class))).thenReturn(staffList);				
		
		assertEquals(staffList, optimiserService.optimiseStaffForJob(job1),"The results not matching!");
	}	

}
