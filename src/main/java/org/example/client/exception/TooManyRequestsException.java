package org.example.client.exception;

import feign.Response;

public class TooManyRequestsException extends Exception {

	public TooManyRequestsException(Response response) {
		super(response.reason());
	}

}
