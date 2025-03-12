package io.swipepay.cryptoservice.payload;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swipepay.cryptoservice.payload.dto.StatusDto;

public class DecryptResponse extends CryptoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cipherDataKey;
	
	@ToStringExclude
	private String plainTextData;
	
	public DecryptResponse(StatusDto status) {
		super(status);
	}
	
	public DecryptResponse(StatusDto status, String cipherDataKey, String plainTextData) {
		super(status);
		this.cipherDataKey = cipherDataKey;
		this.plainTextData = plainTextData;
	}
	
	public String getCipherDataKey() {
		return cipherDataKey;
	}
	
	public void setCipherDataKey(String cipherDataKey) {
		this.cipherDataKey = cipherDataKey;
	}
	
	public String getPlainTextData() {
		return plainTextData;
	}
	
	public void setPlainTextData(String plainTextData) {
		this.plainTextData = plainTextData;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}