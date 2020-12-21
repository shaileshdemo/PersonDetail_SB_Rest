package com.persondetail.sb.rest.api.exception;

import lombok.Data;

@Data
public class PersonDetailServiceException extends Exception {

	private static final long serialVersionUID = -8276059130067105698L;

	private int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public PersonDetailServiceException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

}
