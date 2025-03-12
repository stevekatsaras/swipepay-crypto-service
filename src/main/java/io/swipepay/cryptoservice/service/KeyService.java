package io.swipepay.cryptoservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swipepay.cryptoservice.exception.KeyException;
import io.swipepay.cryptoservice.payload.KeyResponse;
import io.swipepay.cryptoservice.payload.dto.StatusDto;
import io.swipepay.cryptoservice.payload.enums.Status;
import io.swipepay.cryptoservice.support.KeySupport;

@Service
public class KeyService {
	@Autowired
	private KeySupport keySupport;
	
	public KeyResponse generate() throws KeyException {
		String cipherDataKey = null;
		try {
			cipherDataKey = keySupport.generateDataKey();
		}
		catch (Exception exception) {
			throw new KeyException(
					Status.RS_0100, 
					"The cipher data key failed to generate from the AWS key management service (KMS)", 
					exception);
		}
		
		return new KeyResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_0000), 
				cipherDataKey);
	}
}