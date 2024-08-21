package com.insurance.adminservice.exception.response;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.insurance.adminservice.dto.ErrorResponse;
import com.insurance.adminservice.exception.InvalidEmployeeIdException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<ErrorResponse> handlerInvalidEmployeeId(InvalidEmployeeIdException emp)
	{
		ErrorResponse response = new ErrorResponse(emp.getMessage(),emp.getClass().getName(), new Date(), 404);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
