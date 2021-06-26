package com.myapp.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myapp.controller.PasswordValidationController;

@RestControllerAdvice
public class RestExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationException(ValidationException validationException) {
		logger.info("received and handling exception:{}",validationException);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorsList(validationException.errorsList);
		return errorResponse;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleException(Exception exception) {
		logger.info("received and handling exception:{}",exception);
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorObject> errorsList = new ArrayList<>();
		errorsList.add(new ErrorObject("some exception occurred while processing your request, please contact support", null, null));
		errorResponse.setErrorsList(errorsList);
		return errorResponse;
	}
}
