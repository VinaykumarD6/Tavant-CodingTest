package com.tavant.springbootemployee.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.tavant.springbootemployee.exceptions.EmployeeNotFoundException;
import com.tavant.springbootemployee.exceptions.NoRecordsFoundException;
import com.tavant.springbootemployee.errorresponse.ErrorResponse;
import java.util.*;

@ControllerAdvice
public class EmployeeRestControllerAdvice {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e, WebRequest request){
		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(NoRecordsFoundException.class)
	public final ResponseEntity<ErrorResponse> handleNoRecordsFoundException(NoRecordsFoundException e, WebRequest request){
		List<String> details1 = new ArrayList<String>();
		details1.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details1);
		return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
		
	}

}
