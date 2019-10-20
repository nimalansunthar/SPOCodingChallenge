//package com.spo.codingchallenge.runner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.spo.codingchallenge.domain_objects.JobDO;
//import com.spo.codingchallenge.service.JobDOService;
//import com.spo.codingchallenge.util.DefaultStaffOptimiser;
//import com.spo.codingchallenge.util.StaffOptimiser;
//import com.spo.codingchallenge.value_objects.OptimisedStaff;
//
//@Component
//public class TestRunner implements CommandLineRunner{
//
//	@Autowired
//	JobDOService service;
//	
//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println("GreatestCommonDivisor"+GreatestCommonDivisor(10,2));		
//		
//		List<Integer> intArray = Arrays.asList(35, 21, 17, 28);
//		
////		Integer[] rooms = Arrays.stream(intArray).map(Object::toString)
////			    .map(Integer::valueOf)
////				.toArray(Integer[]::new);
//
//				
//		JobDO job = new JobDO();
//		job.setSeniorCapacity(12);
//		job.setJuniorCapacity(11);
//		job.setRooms( intArray);
//		
//		service.addJob(job);
//		
//		
//		StaffOptimiser staffOptimiser = new DefaultStaffOptimiser();
//		List<OptimisedStaff> optimiseStaff = staffOptimiser.optimiseStaffForJob(job);
//		
//		for (OptimisedStaff optimisedStaff : optimiseStaff) {
//			System.out.println( "Senior "+optimisedStaff.getSeniorCount());
//			System.out.println( "junior "+optimisedStaff.getJuniorCount());
//			System.out.println( "Job capacity "+optimisedStaff.getJobCapacity());
//			System.out.println( "with min diff "+optimisedStaff.getMinDiff());
//			System.out.println( "-------------------------------------------- ");
//		}
//		
//		
//		List<Integer> array =  Arrays.asList(35, 21, 17, 28);
//		
//	}
//	
//	 public int GreatestCommonDivisor(int a, int b) {
//	        if (b==0){
//	            return a;
//	        }
//	        return GreatestCommonDivisor(b,a%b);
//	    }
//
//}
