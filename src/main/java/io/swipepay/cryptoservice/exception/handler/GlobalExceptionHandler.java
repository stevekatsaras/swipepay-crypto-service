package io.swipepay.cryptoservice.exception.handler;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import io.swipepay.cryptoservice.exception.DecryptException;
import io.swipepay.cryptoservice.exception.EncryptException;
import io.swipepay.cryptoservice.exception.KeyException;
import io.swipepay.cryptoservice.exception.ValidationException;
import io.swipepay.cryptoservice.payload.CryptoResponse;
import io.swipepay.cryptoservice.payload.dto.StatusDto;
import io.swipepay.cryptoservice.payload.enums.Status;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	// HTTP 400
	
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CryptoResponse handle(BindException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1400));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CryptoResponse handle(HttpMessageNotReadableException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1400));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CryptoResponse handle(MethodArgumentNotValidException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1400));
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CryptoResponse handle(MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1400));
	}
	
	@ExceptionHandler(MissingServletRequestPartException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CryptoResponse handle(MissingServletRequestPartException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1400));
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CryptoResponse handle(MissingServletRequestParameterException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1400));
	}

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CryptoResponse handle(TypeMismatchException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1400));
	}
	
	// HTTP 405
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public CryptoResponse handle(HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1405));
	}
	
	// HTTP 415
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public CryptoResponse handle(HttpMediaTypeNotSupportedException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1415));
	}
	
	// Catch all (default to HTTP 500)
	
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CryptoResponse handle(ValidationException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						exception.getStatus()));
	}
	
	@ExceptionHandler(KeyException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CryptoResponse handle(KeyException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						exception.getStatus()));
	}
	
	@ExceptionHandler(EncryptException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CryptoResponse handle(EncryptException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						exception.getStatus()));
	}
	
	@ExceptionHandler(DecryptException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public CryptoResponse handle(DecryptException exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						exception.getStatus()));
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CryptoResponse handleAll(Exception exception, HttpServletRequest request) {
		return new CryptoResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_1500));
    }
}