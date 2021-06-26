package com.myapp.exception;

import java.util.List;

public class ErrorResponse {
	List<ErrorObject> errorsList;

	public List<ErrorObject> getErrors() {
		return errorsList;
	}

	public void setErrorsList(List<ErrorObject> errorsList) {
		this.errorsList = errorsList;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorsList=" + errorsList + "]";
	}
}
