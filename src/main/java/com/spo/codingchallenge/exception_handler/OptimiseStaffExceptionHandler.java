package com.spo.codingchallenge.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spo.codingchallenge.exceptions.OptimiseStaffException;

/**
 * Controller advice for the exceptions generated in the optimisation process
 * @author ex1
 *
 */
@ControllerAdvice
public class OptimiseStaffExceptionHandler {
	@ResponseBody
	@ExceptionHandler(OptimiseStaffException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String carAlreadyInUseExceptionMessage(OptimiseStaffException ex) {
		return ex.getMessage();
	}
}