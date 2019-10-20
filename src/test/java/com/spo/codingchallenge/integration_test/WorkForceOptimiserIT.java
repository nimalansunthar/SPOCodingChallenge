package com.spo.codingchallenge.integration_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spo.codingchallenge.WorkForceOptimiserApplication;
import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.dto.CommonOptimisedStaffResponse;
import com.spo.codingchallenge.object_mapper.OptimisedStaffDTOMapper;
import com.spo.codingchallenge.value_objects.OptimisedStaff;

/**
 * Integration tests. Tests all the integrated layers .
 * @author ex1
 *
 */
@SpringBootTest(classes = WorkForceOptimiserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkForceOptimiserIT {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;
	private HttpHeaders headers = new HttpHeaders();
	
	@Test
	void testOptimiseWorkForce() {

		String URIToOptimiseWorkForce = "/v1/staffoptimiser";
		
		List<Integer> rooms = Arrays.asList(35, 21, 17, 28);		
		JobDO job = new JobDO(rooms, 10, 6); 

		HttpEntity<JobDO> requestBody = new HttpEntity<JobDO>(job, headers);		
		
		OptimisedStaff optStaff1 = new OptimisedStaff(1, 3, 1);
		OptimisedStaff optStaff2 = new OptimisedStaff(1, 1, 2);
		OptimisedStaff optStaff3 = new OptimisedStaff(3, 2, 0);
		OptimisedStaff optStaff4 = new OptimisedStaff(0, 1, 3);
		
		List<OptimisedStaff> optStaffList = Arrays.asList(optStaff1,optStaff2,optStaff3,optStaff4);
		
		List<Map<String, Integer>> expectedOutput = OptimisedStaffDTOMapper.mapToDTO(optStaffList);   

		ResponseEntity <CommonOptimisedStaffResponse> responseEntity = testRestTemplate
				.exchange(formFullURLWithPort(URIToOptimiseWorkForce), HttpMethod.POST, requestBody, CommonOptimisedStaffResponse.class);				

		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue(), "The response status is not matching!");		
		
		CommonOptimisedStaffResponse response = responseEntity.getBody();

		List<Map<String, Integer>> responseData = response.getData();       
	       
		assertEquals(4, responseData.size(), "The size of the data didn't match!");                  

        assertEquals(expectedOutput,responseData,"The data didn't match!");		
		
	}
	
	/**
	 * This Test tests the Senior capacity must be greater than Junior capacity constraint
	 */
	
	@Test
	void assertValidationExceptions() {			
		
		String URIToOptimiseWorkForce = "/v1/staffoptimiser";
		
		List<Integer> rooms = Arrays.asList(35, 21, 17, 28);		
		JobDO job = new JobDO(rooms, 5, 11); 
		
		HttpEntity<JobDO> requestBody = new HttpEntity<JobDO>(job, headers);	
		
		ResponseEntity <Map<String, String>> responseEntity = testRestTemplate
				.exchange(formFullURLWithPort(URIToOptimiseWorkForce), HttpMethod.POST, requestBody, new ParameterizedTypeReference<Map<String, String>>()
                {});					
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue(), "The response status is not matching!");
		
		Map<String, String> responseData = responseEntity.getBody();  		
	       
		assertEquals(1, responseData.size(), "The size of the data didn't match!"); 
		
		String message = "Senior capacity is always greater than Junior capacity!";   

        assertEquals(responseData.get("Senior Capacity: Junior Capacity"), message,"The messege didn't match!");			
       
	}
	
	
	 /**
     * This utility method to create the url for given uri. It appends the
     * RANDOM_PORT generated port
     */
    private String formFullURLWithPort(String uri)
    {
        return "http://localhost:" + port + uri;
    }
}
