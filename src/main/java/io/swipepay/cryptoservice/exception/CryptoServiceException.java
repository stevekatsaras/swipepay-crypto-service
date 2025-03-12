package io.swipepay.cryptoservice.exception;

import io.swipepay.cryptoservice.payload.enums.Status;

public class CryptoServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Status status;
	
	public CryptoServiceException(Status status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
}