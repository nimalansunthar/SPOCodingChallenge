package com.spo.codingchallenge.object_mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spo.codingchallenge.value_objects.OptimisedStaff;
/**
 * Map domain objects into data transfer object
 * @author ex1
 *
 */
@Component
public class OptimisedStaffDTOMapper {	
	
	public static List<Map<String, Integer>> mapToDTO(List<OptimisedStaff> listDO) {
		
		List<Map<String,Integer>> staffDTOList = new ArrayList<Map<String,Integer>>();		
		
		for(OptimisedStaff optimisedStaff:listDO) {
			
			Map<String,Integer> staffDTOMap = new HashMap<>();
			
			staffDTOMap.put("senior", optimisedStaff.getSeniorCount());
			staffDTOMap.put("junior", optimisedStaff.getJuniorCount());
			
			staffDTOList.add(staffDTOMap);		
		}		
		
		return  staffDTOList;
	}
}
