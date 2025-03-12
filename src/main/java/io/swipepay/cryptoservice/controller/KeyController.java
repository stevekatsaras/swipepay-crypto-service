package io.swipepay.cryptoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swipepay.cryptoservice.payload.KeyResponse;
import io.swipepay.cryptoservice.service.KeyService;

@RestController
@RequestMapping(value = "/key")
public class KeyController {
	@Autowired
	private KeyService keyService;
	
	@RequestMapping(
			value = "/generate", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public KeyResponse generate() {
		return keyService.generate();
	}
}