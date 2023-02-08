package com.te.ecombasepack.exception;

public class CustomerException extends RuntimeException {

	private String errmessage;
	
	

	public CustomerException(String errmessage) {
		super();
		this.errmessage = errmessage;
	}

	public CustomerException() {
		super();
	}

	public String getErrmessage() {
		return errmessage;
	}

	public void setErrmessage(String errmessage) {
		this.errmessage = errmessage;
	}
	
	
}
