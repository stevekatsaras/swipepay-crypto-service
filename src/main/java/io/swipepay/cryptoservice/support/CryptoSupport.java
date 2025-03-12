package io.swipepay.cryptoservice.support;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import com.amazonaws.util.Base64;

@Component
public class CryptoSupport {
	
	public String decrypt(SecretKeySpec secretKeySpec, String cipherTextData) throws Exception {
		byte[] plainTextBytes = Base64.decode(cipherTextData);
		
		Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		return new String(cipher.doFinal(plainTextBytes));
	}
	
	public String encrypt(SecretKeySpec secretKeySpec, String plainTextData) throws Exception {
		Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] cipherTextBytes = cipher.doFinal(plainTextData.getBytes());
		
		return Base64.encodeAsString(cipherTextBytes);
	}
}