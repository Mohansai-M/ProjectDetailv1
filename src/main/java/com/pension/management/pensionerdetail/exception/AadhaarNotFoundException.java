package com.pension.management.pensionerdetail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AadhaarNotFoundException extends RuntimeException {
	private String AadhaarNumber;

	public AadhaarNotFoundException(String AadhaarNumber) {
		super(String.format("Pensioner Details not found with AadhaarNumber : '%s'", AadhaarNumber)); // Post not found with
																									// id : 1
		this.AadhaarNumber = AadhaarNumber;
	}

}