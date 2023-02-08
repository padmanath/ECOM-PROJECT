package com.te.ecombasepack.exception;

public class ShippingAddressException extends RuntimeException {

	private String errmessage;

	public ShippingAddressException() {
		super();
	}

	public ShippingAddressException(String errmessage) {
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
