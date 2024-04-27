package org.example.client.exception;

import feign.Response;

public class BadRequestException extends Exception {

	public BadRequestException(String reason) {
		super(reason);
	}

}
