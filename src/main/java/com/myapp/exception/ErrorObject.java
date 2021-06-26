package com.myapp.exception;

public class ErrorObject {

	private String errorMessage;
	private String key;
	private Object value;
	
	public ErrorObject() {
		
	}
	
	public ErrorObject(String errorMessage, String key, Object value) {
		super();
		this.errorMessage = errorMessage;
		this.key = key;
		this.value = value;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ErrorObject [errorMessage=" + errorMessage + ", key=" + key + ", value=" + value + "]";
	}
	
	
}
