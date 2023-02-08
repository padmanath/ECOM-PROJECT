package com.te.ecombasepack.exception;

public class ProductException extends RuntimeException {
       
	private String errmessage;
	
	

	public ProductException(String errmessage) {
		super();
		this.errmessage = errmessage;
	}

	public String getErrmessage() {
		return errmessage;
	}

	public void setErrmessage(String errmessage) {
		this.errmessage = errmessage;
	}

	
	
}
