package io.swipepay.cryptoservice.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

public class AwsCredentialsProperties {
	@NotBlank(message = "Access key is required")
	private String accessKey;
	
	@NotBlank(message = "Secret key is required")
	private String secretKey;
	
	public AwsCredentialsProperties() {
		
	}
	
	public AwsCredentialsProperties(String accessKey, String secretKey) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}
	
	public String getAccessKey() {
		return accessKey;
	}
	
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	
	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}