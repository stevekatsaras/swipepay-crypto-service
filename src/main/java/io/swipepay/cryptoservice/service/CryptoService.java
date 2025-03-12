package io.swipepay.cryptoservice.service;

import java.time.Instant;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swipepay.cryptoservice.payload.DecryptRequest;
import io.swipepay.cryptoservice.payload.DecryptResponse;
import io.swipepay.cryptoservice.payload.EncryptRequest;
import io.swipepay.cryptoservice.payload.EncryptResponse;
import io.swipepay.cryptoservice.payload.dto.StatusDto;
import io.swipepay.cryptoservice.payload.enums.Status;
import io.swipepay.cryptoservice.exception.DecryptException;
import io.swipepay.cryptoservice.exception.EncryptException;
import io.swipepay.cryptoservice.support.CryptoSupport;
import io.swipepay.cryptoservice.support.KeySupport;

@Service
public class CryptoService {
	@Autowired
	private CryptoSupport cryptoSupport;
	
	@Autowired
	private KeySupport keySupport;
	
	public DecryptResponse decrypt(DecryptRequest decryptRequest) throws DecryptException {
		String plainTextData = null;
		try {
			SecretKeySpec secretKeySpec = decryptCipherDataKey(decryptRequest.getCipherDataKey());
			plainTextData = cryptoSupport.decrypt(secretKeySpec, decryptRequest.getCipherTextData());
		}
		catch (DecryptException exception) {
			throw exception;
		}
		catch (Exception exception) {
			throw new DecryptException(
					Status.RS_0106, 
					"The cipher text data failed to decrypt from the AWS key management service (KMS)", 
					exception);
		}

		return new DecryptResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_0000), 
				decryptRequest.getCipherDataKey(), 
				plainTextData);
	}
	
	public EncryptResponse encrypt(EncryptRequest encryptRequest) throws EncryptException, DecryptException {
		String cipherTextData = null;
		try {
			SecretKeySpec secretKeySpec = decryptCipherDataKey(encryptRequest.getCipherDataKey());
			cipherTextData = cryptoSupport.encrypt(secretKeySpec, encryptRequest.getPlainTextData());
		}
		catch (DecryptException exception) {
			throw exception;
		}
		catch (Exception exception) {
			throw new EncryptException(
					Status.RS_0104, 
					"The plain text data failed to encrypt from the AWS key management service (KMS)", 
					exception);
		}
		
		return new EncryptResponse(
				new StatusDto(
						Instant.now().toEpochMilli(), 
						Status.RS_0000), 
				encryptRequest.getCipherDataKey(), 
				cipherTextData);
	}
	
	private SecretKeySpec decryptCipherDataKey(String cipherDataKey) throws DecryptException {
		SecretKeySpec secretKeySpec = null;
		try {
			secretKeySpec = keySupport.decryptDataKey(cipherDataKey);
		}
		catch (Exception exception) {
			throw new DecryptException(
					Status.RS_0102, 
					"The cipher data key failed to decrypt from the AWS key management service (KMS). This is required to perform crypto functions", 
					exception);
		}
		return secretKeySpec;
	}
	
}