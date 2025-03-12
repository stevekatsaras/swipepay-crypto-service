package io.swipepay.cryptoservice.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.swipepay.cryptoservice.exception.ValidationException;
import io.swipepay.cryptoservice.payload.EncryptRequest;
import io.swipepay.cryptoservice.payload.enums.Status;

@Component
public class EncryptValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EncryptRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}
	
	public void validate(EncryptRequest encryptRequest) throws ValidationException {
		if (StringUtils.isBlank(encryptRequest.getCipherDataKey())) {
			throw new ValidationException(
					Status.RS_0101, 
					"Validation failed because the cipher data key has not been supplied in the EncryptRequest class", 
					null);
		}
		else if (StringUtils.isBlank(encryptRequest.getPlainTextData())) {
			throw new ValidationException(
					Status.RS_0103, 
					"Validation failed because the plain text data has not been supplied in the EncryptRequest class", 
					null);
		}
	}
}