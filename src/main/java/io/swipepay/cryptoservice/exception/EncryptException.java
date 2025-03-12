package io.swipepay.cryptoservice.exception;

import io.swipepay.cryptoservice.payload.enums.Status;

public class EncryptException extends CryptoServiceException {
	private static final long serialVersionUID = 1L;
	
	public EncryptException(Status status, String message, Throwable cause) {
		super(status, message, cause);
	}
}