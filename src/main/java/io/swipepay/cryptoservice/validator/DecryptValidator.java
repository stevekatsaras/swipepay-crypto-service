package io.swipepay.cryptoservice.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.swipepay.cryptoservice.exception.ValidationException;
import io.swipepay.cryptoservice.payload.DecryptRequest;
import io.swipepay.cryptoservice.payload.enums.Status;

@Component
public class DecryptValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DecryptRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}
	
	public void validate(DecryptRequest decryptRequest) throws ValidationException {
		if (StringUtils.isBlank(decryptRequest.getCipherDataKey())) {
			throw new ValidationException(
					Status.RS_0101, 
					"Validation failed because the cipher data key has not been supplied in the DecryptRequest class", 
					null);
		}
		else if (StringUtils.isBlank(decryptRequest.getCipherTextData())) {
			throw new ValidationException(
					Status.RS_0105, 
					"Validation failed because the cipher text data has not been supplied in the DecryptRequest class", 
					null);
		}
	}
	
}
