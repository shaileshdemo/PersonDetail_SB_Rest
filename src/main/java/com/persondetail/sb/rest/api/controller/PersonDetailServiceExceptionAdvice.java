package com.persondetail.sb.rest.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.persondetail.sb.rest.api.entity.ErrorMessage;
import com.persondetail.sb.rest.api.exception.PersonDetailServiceException;

@ControllerAdvice
public class PersonDetailServiceExceptionAdvice {

	public ResponseEntity<ErrorMessage> mapException(PersonDetailServiceException ex) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
