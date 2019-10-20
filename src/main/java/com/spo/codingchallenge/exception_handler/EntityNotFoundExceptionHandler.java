package com.spo.codingchallenge.exception_handler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spo.codingchallenge.exceptions.EntityNotFoundException;

@ControllerAdvice
public class EntityNotFoundExceptionHandler {
	@ResponseBody
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String carAlreadyInUseExceptionMessage(EntityNotFoundException ex) {
		return ex.getMessage();
	}
}