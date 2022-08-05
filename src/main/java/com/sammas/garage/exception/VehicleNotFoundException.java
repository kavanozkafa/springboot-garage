package com.sammas.garage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6522457954230921014L;

	public VehicleNotFoundException(String ticketId) {
		super("Vehicle's parking ticket id not found : " + ticketId);
	}
}