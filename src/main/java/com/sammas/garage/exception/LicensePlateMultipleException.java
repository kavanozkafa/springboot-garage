package com.sammas.garage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class LicensePlateMultipleException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4283190749019113625L;

	public LicensePlateMultipleException(String licensePlate) {
		super("There is a vehicle with this license plate !" + licensePlate);
	}
}