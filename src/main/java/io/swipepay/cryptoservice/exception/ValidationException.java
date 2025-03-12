package io.swipepay.cryptoservice.exception;

import io.swipepay.cryptoservice.payload.enums.Status;

public class ValidationException extends CryptoServiceException {
	private static final long serialVersionUID = 1L;
	
	public ValidationException(Status status, String message, Throwable cause) {
		super(status, message, cause);
	}
}