package io.swipepay.cryptoservice.payload;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swipepay.cryptoservice.payload.dto.StatusDto;

public class KeyResponse extends CryptoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cipherDataKey;
	
	public KeyResponse(StatusDto status) {
		super(status);
	}
	
	public KeyResponse(StatusDto status, String cipherDataKey) {
		super(status);
		this.cipherDataKey = cipherDataKey;
	}
	
	public String getCipherDataKey() {
		return cipherDataKey;
	}

	public void setCipherDataKey(String cipherDataKey) {
		this.cipherDataKey = cipherDataKey;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}