package io.swipepay.cryptoservice.payload.enums;

public enum Status {
	RS_0000("0000", "Ok"),
	RS_0100("0100", "Cipher data key failed to generate"), 
	RS_0101("0101", "Cipher data key not supplied"),
	RS_0102("0102", "Cipher data key not decrypted"),
	RS_0103("0103", "Plain text data not supplied"),
	RS_0104("0104", "Plain text data not encrypted"), 
	RS_0105("0105", "Cipher text data not supplied"),
	RS_0106("0106", "Cipher text data not decrypted"), 
	
	RS_1400("1400", "Bad request"),
	RS_1405("1405", "HTTP request method not supported"),
	RS_1415("1415", "Unsupported HTTP media type"), 
	RS_1500("1500", "Internal server error");
	
	private final String code;
	private final String text;
	
	private Status(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public String getText() {
		return text;
	}
}