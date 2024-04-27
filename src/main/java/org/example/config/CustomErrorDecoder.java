package org.example.config;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatusCode;

public class CustomErrorDecoder implements ErrorDecoder {
	@Override
	public Exception decode(String methodKey, Response response) {

		if (HttpStatusCode.valueOf(response.status()).is5xxServerError()) {
			return new Exception();
			//new RetryableException("response.status()", "5xx exception", "1", "2", response.request()) ;
		}
		return new Exception("Generic exception");
	}
}