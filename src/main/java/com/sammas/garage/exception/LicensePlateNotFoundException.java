package com.sammas.garage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LicensePlateNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3926074156835383933L;

	public LicensePlateNotFoundException(String ticketId) {
		super("There is no vehicle with this license plate !" + ticketId);
	}
}