package com.myapp.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ErrorObject> errorsList=new ArrayList<>();
	
	public void add(String errorMessage, String key, Object value) {
		errorsList.add(new ErrorObject(errorMessage, key, value));
	}

	public List<ErrorObject> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<ErrorObject> errorsList) {
		this.errorsList = errorsList;
	}
	
	
}
