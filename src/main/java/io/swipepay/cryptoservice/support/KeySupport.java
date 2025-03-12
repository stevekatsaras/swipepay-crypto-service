package io.swipepay.cryptoservice.support;

import java.nio.ByteBuffer;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.DecryptResult;
import com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult;
import com.amazonaws.util.Base64;

import io.swipepay.cryptoservice.properties.AwsKmsProperties;

@Component
public class KeySupport {
	@Autowired
	private AwsKmsProperties awsKmsProperties;
	
	@Autowired
	private AWSKMSClient awsKmsClient;
	
	public String generateDataKey() throws Exception {
		GenerateDataKeyWithoutPlaintextRequest awsWebServiceRequest = new GenerateDataKeyWithoutPlaintextRequest()
				.withKeyId(awsKmsProperties.getCmkId())
				.withKeySpec(awsKmsProperties.getDataKeySpec());
		
		GenerateDataKeyWithoutPlaintextResult awsWebServiceResponse = awsKmsClient.generateDataKeyWithoutPlaintext(
				awsWebServiceRequest);
		
		return Base64.encodeAsString(awsWebServiceResponse.getCiphertextBlob().array());
	}
	
	public SecretKeySpec decryptDataKey(String cipherDataKey)  throws Exception {
		ByteBuffer cipherDataKeyBlob = ByteBuffer.wrap(Base64.decode(cipherDataKey));
		
		DecryptRequest awsWebServiceRequest = new DecryptRequest().withCiphertextBlob(cipherDataKeyBlob);
		DecryptResult awsWebServiceResponse = awsKmsClient.decrypt(awsWebServiceRequest);
		
		return new SecretKeySpec(awsWebServiceResponse.getPlaintext().array(), awsKmsProperties.getDataKeyAlgorithm());
	}
}