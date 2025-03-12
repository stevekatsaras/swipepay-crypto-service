package io.swipepay.cryptoservice.exception;

import io.swipepay.cryptoservice.payload.enums.Status;

public class DecryptException extends CryptoServiceException {
	private static final long serialVersionUID = 1L;
	
	public DecryptException(Status status, String message, Throwable cause) {
		super(status, message, cause);
	}
}