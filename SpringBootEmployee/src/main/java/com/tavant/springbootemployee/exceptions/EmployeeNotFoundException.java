package com.tavant.springbootemployee.exceptions;

public class EmployeeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
