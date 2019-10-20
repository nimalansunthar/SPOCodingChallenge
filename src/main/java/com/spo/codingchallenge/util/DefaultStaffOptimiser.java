package com.spo.codingchallenge.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spo.codingchallenge.domain_objects.JobDO;
import com.spo.codingchallenge.exceptions.OptimiseStaffException;
import com.spo.codingchallenge.value_objects.OptimisedStaff;
/**
 * default implementation of StaffOptimiser
 * @author ex1
 *
 */
@Component
public class DefaultStaffOptimiser implements StaffOptimiser{

	@Autowired
	private final static Logger logger = LoggerFactory.getLogger(DefaultStaffOptimiser.class);
	
	/**
	 * This function calculates the optimum result for all the structures by looping through each structure
	 * @return List of OptimisedStaff objects
	 */
	@Override
	public List<OptimisedStaff> optimiseStaffForJob(JobDO jobDO) {
		
		List<OptimisedStaff> staffList = new ArrayList<>();
	
		Integer sCapacity = jobDO.getSeniorCapacity();
		Integer jCapacity = jobDO.getJuniorCapacity();
		try {
			for(Integer rooms:jobDO.getRooms()) {
		
				staffList.add(optimiseStaffPerStructure(rooms, sCapacity, jCapacity));				
			}	
		}catch(Exception ex) {
			logger.error("{} -> {}", DefaultStaffOptimiser.class, Util.STATUS_FAILED);
			throw new OptimiseStaffException ("Error Occured while executing optimise staff! "+ ex.getMessage(), ex);
		}
		return staffList;		
	}	
	
	
	/**
	 * This function is to calculate the optimum result in a particular structure.
	 * @param rooms - no of rooms in the structure
	 * @param sCapacity - senior capacity
	 * @param jCapacity - junior capacity
	 * @return - the optimal result in the OptimisedStaff
	 */
	private OptimisedStaff optimiseStaffPerStructure(Integer rooms, Integer sCapacity, Integer jCapacity) {
		
		int initialSeniors =  (int)Math.ceil((double)rooms/(double)sCapacity); 
        int initialJuniors = 0; 			
		
		OptimisedStaff optimisedStaff = new OptimisedStaff(Integer.MAX_VALUE, initialSeniors, initialJuniors, rooms);
		
		return findOptimalStaff(optimisedStaff,rooms,sCapacity,jCapacity,initialSeniors,initialJuniors);          	
	}


	/**
	 * Recursive function to find optimum values by reducing senior staff one by one and adding junior staff 
	 * one by one until the excess capacity becomes zero or senior staff equal to 1.
	 * 
	 * @param optimisedStaff - object to assign optimum values
	 * @param rooms - no of rooms in the structure
	 * @param sCapacity - senior capacity
	 * @param jCapacity - junior capacity
	 * @param currentSeniors - no of seniors assigned in the current iteration.
	 * @param currentJuniors - no of juniors assigned in the current iteration.
	 * @return - the optimal result in the OptimisedStaff
	 */
	private OptimisedStaff findOptimalStaff(OptimisedStaff optimisedStaff, int rooms, Integer sCapacity,
			Integer jCapacity, int currentSeniors, int currentJuniors) {		
		
		int currentStaffCapacity = (sCapacity * currentSeniors) + (jCapacity * currentJuniors);
        int diff = currentStaffCapacity-rooms;             
        
        if(diff == 0 ) {        	
        	assignOptimal(optimisedStaff, currentSeniors, currentJuniors, diff);
        	return optimisedStaff;     
        }
        
        if(diff > 0 && currentSeniors == 1 && diff < jCapacity){ // Can't go further minimum senior requirement reached        	
            assignOptimal(optimisedStaff, currentSeniors, currentJuniors, diff);
            return optimisedStaff; 
        }        
        
        if( diff > 0 && currentSeniors > 1){	 // continue to find optimal result        	        
        	assignOptimal(optimisedStaff, currentSeniors, currentJuniors, diff);
            return findOptimalStaff(optimisedStaff, rooms, sCapacity, jCapacity, currentSeniors-1, currentJuniors+1);
        }
        
        if(diff<0){		//continue by adding required junior staff   
        	int increment = (Math.abs(diff)/jCapacity);
        	if(increment==0)
        		increment++;
            return findOptimalStaff(optimisedStaff, rooms, sCapacity, jCapacity, currentSeniors, currentJuniors+increment);
        }        
        
        return optimisedStaff;
    }

	/**
	 * Function to add the optimum result in the OptimisedStaff object.
	 * @param optimisedStaff
	 * @param currentSeniors
	 * @param currentJuniors
	 * @param diff
	 */
	private void assignOptimal(OptimisedStaff optimisedStaff, int currentSeniors, int currentJuniors, int diff) {
		
		if(diff >= 0 && diff < optimisedStaff.getMinDiff()) {      
        	
        	optimisedStaff.setMinDiff(diff);        	
        	optimisedStaff.setSeniorCount(currentSeniors);
        	optimisedStaff.setJuniorCount(currentJuniors);
        }
	}
}
