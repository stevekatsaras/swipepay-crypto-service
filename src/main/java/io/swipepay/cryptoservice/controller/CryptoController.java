package io.swipepay.cryptoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swipepay.cryptoservice.payload.DecryptRequest;
import io.swipepay.cryptoservice.payload.DecryptResponse;
import io.swipepay.cryptoservice.payload.EncryptRequest;
import io.swipepay.cryptoservice.payload.EncryptResponse;
import io.swipepay.cryptoservice.service.CryptoService;
import io.swipepay.cryptoservice.validator.DecryptValidator;
import io.swipepay.cryptoservice.validator.EncryptValidator;

@RestController
@RequestMapping(value = "/crypto")
public class CryptoController {
	@Autowired
	private CryptoService cryptoService;
	
	@Autowired
	private DecryptValidator decryptValidator;
	
	@Autowired
	private EncryptValidator encryptValidator;
	
	@RequestMapping(
			value = "/decrypt", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public DecryptResponse decrypt(@RequestBody DecryptRequest decryptRequest) {
		decryptValidator.validate(decryptRequest);
		return cryptoService.decrypt(decryptRequest);
	}
	
	@RequestMapping(
			value = "/encrypt", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EncryptResponse encrypt(@RequestBody EncryptRequest encryptRequest) {
		encryptValidator.validate(encryptRequest);
		return cryptoService.encrypt(encryptRequest);
	}
}