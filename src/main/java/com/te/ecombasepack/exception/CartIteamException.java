package com.te.ecombasepack.exception;

public class CartIteamException extends RuntimeException{
	
	private String errmessage;
	private String message;
	
	

	public CartIteamException(String errmessage, String message) {
		super();
		this.errmessage = errmessage;
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public CartIteamException() {
		super();
	}
	

	public CartIteamException(String errmessage) {
		super();
		this.errmessage = errmessage;
	}


	public String getErrmessage() {
		return errmessage;
	}

	
	
}
