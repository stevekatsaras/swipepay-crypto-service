package io.swipepay.cryptoservice.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

public class AwsKmsProperties {
	@NotBlank(message = "Service endpoint is required")
	private String serviceEndpoint;
	
	@NotBlank(message = "Signing region is required")
	private String signingRegion;
	
	@NotBlank(message = "CMK ID is required")
	private String cmkId;
	
	@NotBlank(message = "Data key algorithm is required")
	private String dataKeyAlgorithm;
	
	@NotBlank(message = "Data key spec is required")
	private String dataKeySpec;
	
	public AwsKmsProperties() {
		
	}
	
	public AwsKmsProperties(
			String serviceEndpoint, 
			String signingRegion, 
			String cmkId, 
			String dataKeyAlgorithm,
			String dataKeySpec) {
		this.serviceEndpoint = serviceEndpoint;
		this.signingRegion = signingRegion;
		this.cmkId = cmkId;
		this.dataKeyAlgorithm = dataKeyAlgorithm;
		this.dataKeySpec = dataKeySpec;
	}

	public String getServiceEndpoint() {
		return serviceEndpoint;
	}
	
	public void setServiceEndpoint(String serviceEndpoint) {
		this.serviceEndpoint = serviceEndpoint;
	}
	
	public String getSigningRegion() {
		return signingRegion;
	}
	
	public void setSigningRegion(String signingRegion) {
		this.signingRegion = signingRegion;
	}
		
	public String getCmkId() {
		return cmkId;
	}

	public void setCmkId(String cmkId) {
		this.cmkId = cmkId;
	}

	public String getDataKeyAlgorithm() {
		return dataKeyAlgorithm;
	}

	public void setDataKeyAlgorithm(String dataKeyAlgorithm) {
		this.dataKeyAlgorithm = dataKeyAlgorithm;
	}

	public String getDataKeySpec() {
		return dataKeySpec;
	}

	public void setDataKeySpec(String dataKeySpec) {
		this.dataKeySpec = dataKeySpec;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}