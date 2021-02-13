package com.tavant.springbootemployee.errorresponse;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import java.util.*;
import lombok.Data;

@Data

public class ApiError implements Serializable {
	private static final Long serialVersionUID = 1L;
	private HttpStatus status;
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<ApiSubError> subErrors;
	private void ApiError() {
		timestamp = LocalDateTime.now();
	}

	private void ApiError(HttpStatus status) {
		this.status = status;
	}
	private void ApiError(HttpStatus status, Throwable ex) {
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}
	private void ApiError(HttpStatus status, String message, Throwable ex) {
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	
	
}
