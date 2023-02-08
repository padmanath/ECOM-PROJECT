package com.te.ecombasepack.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.ecombasepack.response.EcomResponse;

@ControllerAdvice
public class HandlerForException {

	@Autowired
	private EcomResponse ecomResponse;

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<EcomResponse> productException(ProductException productException) {
		ecomResponse.setMessage(productException.getErrmessage());
		return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

	}

	@ExceptionHandler(CartIteamException.class)
	public ResponseEntity<EcomResponse> cartIteamException(CartIteamException cartIteamException) {
		ecomResponse.setMessage(cartIteamException.getErrmessage());
		ecomResponse.setMessage(cartIteamException.getMessage());
		return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<EcomResponse> productException(CustomerException customerException) {
		ecomResponse.setMessage(customerException.getErrmessage());
		return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(BillingAddressException.class)
	public ResponseEntity<EcomResponse> productException(BillingAddressException billingAddressException) {
		ecomResponse.setMessage(billingAddressException.getErrmessage());
		return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

	}

	@ExceptionHandler(ShippingAddressException.class)
	public ResponseEntity<EcomResponse> productException(ShippingAddressException shippingAddressException) {
		ecomResponse.setMessage(shippingAddressException.getErrmessage());
		return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

	}

}
