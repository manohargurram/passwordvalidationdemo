package com.myapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleException(ValidationException validationException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorsList(validationException.errorsList);
		return errorResponse;
	}
}
