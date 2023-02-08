package com.te.ecombasepack.exception;

public class BillingAddressException extends RuntimeException {

	private String errmessage;

	public BillingAddressException() {
		super();
	}
	

	public BillingAddressException(String errmessage) {
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
