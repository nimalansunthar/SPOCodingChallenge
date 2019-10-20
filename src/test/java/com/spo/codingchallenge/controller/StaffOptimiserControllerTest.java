package com.spo.codingchallenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.dto.CommonOptimisedStaffResponse;
import com.spo.codingchallenge.object_mapper.OptimisedStaffDTOMapper;
import com.spo.codingchallenge.service.StaffOptimiserService;
import com.spo.codingchallenge.value_objects.OptimisedStaff;

@WebMvcTest(value = StaffOptimiserController.class, secure = false)
@ExtendWith(SpringExtension.class)
public class StaffOptimiserControllerTest {
	
	
	@MockBean
	StaffOptimiserService optimiserService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	MockMvc mockMvc;


	@BeforeEach
	void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}	
	
	@Test
	void testOptimiseStaff() throws Exception {				
		
		//Prepare input job
		
		List<Integer> rooms = Arrays.asList(35, 21, 17, 28);		
		JobDO job = new JobDO(rooms, 11, 6); 
		String inputInJson = objectMapper.writeValueAsString(job);
		
		//prepare result for mock 
		
		OptimisedStaff optStaff1 = new OptimisedStaff(1, 3, 3);
		OptimisedStaff optStaff2 = new OptimisedStaff(1, 1, 2);
		OptimisedStaff optStaff3 = new OptimisedStaff(3, 2, 0);
		OptimisedStaff optStaff4 = new OptimisedStaff(0, 1, 3);
		
		List<OptimisedStaff> optStaffList = Arrays.asList(optStaff1,optStaff2,optStaff3,optStaff4);

		//and mock
        when(optimiserService.optimiseStaffForJob(Mockito.any(JobDO.class))).thenReturn(optStaffList);
        
        //prepare output
        List<Map<String, Integer>> expectedOutput = OptimisedStaffDTOMapper.mapToDTO(optStaffList);    
       
        
        RequestBuilder requestBuilder =
            MockMvcRequestBuilders
                .post("/v1/staffoptimiser")
                .accept(MediaType.APPLICATION_JSON)
                .content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        
        CommonOptimisedStaffResponse commonResponse = objectMapper.readValue((response.getContentAsString()),
				CommonOptimisedStaffResponse.class);
        
        List<Map<String, Integer>> responseData = commonResponse.getData();       
       
		assertEquals(4, responseData.size(), "The size of the data didn't match!");           

        assertEquals(response.getStatus(), HttpStatus.OK.value(),"The status didn't match!");        

        assertEquals(expectedOutput,responseData,"The data didn't match!");

	}

}
