package com.spo.codingchallenge.exception_handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice for validation errors.
 * @author ex1
 *
 */
@ControllerAdvice
public class ValidationExceptionHandlers {

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		
		Map<String, String> errors = new HashMap<>();	

		ex.getBindingResult().getAllErrors().forEach((error) -> {				
			String fieldName;
			String errorMessage = error.getDefaultMessage();			
			if(error.getCode().equals("CompareCapacity"))
				fieldName = "Senior Capacity: Junior Capacity";				
			else 				
				fieldName = ((FieldError) error).getField();
		
			errors.put(fieldName, errorMessage);
		 	});		
		return errors;
	}
}
