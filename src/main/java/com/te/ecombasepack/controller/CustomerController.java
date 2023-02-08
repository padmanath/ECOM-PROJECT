package com.te.ecombasepack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecombasepack.dto.BillingAddressDto;
import com.te.ecombasepack.dto.CustomerDto;
import com.te.ecombasepack.dto.ShippingAdressDto;
import com.te.ecombasepack.entity.BillingAdressEntity;
import com.te.ecombasepack.entity.CustomerEntity;
import com.te.ecombasepack.entity.ShippingAddressEntity;
import com.te.ecombasepack.response.EcomResponse;
import com.te.ecombasepack.service.ServiceInterface;
import com.te.ecombasepack.serviceImpl.ServiceImplementation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

	@Autowired
	private EcomResponse ecomResponse;

	
	private final ServiceInterface serviceInterface;

	// CUSTOMER CONTROLLER

	@PostMapping("/createCustomer")
	public ResponseEntity<EcomResponse> saveProduct(@RequestBody @Valid CustomerDto customerDto) {
		boolean customerDetail = serviceInterface.createCustomerDetail(customerDto);
		if (customerDetail == true) {
			ecomResponse.setMessage("customer detail saved successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("customer details not saved");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("/updateCustomerDetail")
	public ResponseEntity<EcomResponse> updateCustomerDeatil(@RequestBody @Valid CustomerDto customerDto) {
		CustomerEntity updateCustomerDetail = serviceInterface.updateCustomerDetail(customerDto);
		if (updateCustomerDetail != null) {
			ecomResponse.setMessage("customer detail update successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("customer details not updated");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/getCustomerDetail")
	public ResponseEntity<EcomResponse> getCustomerDeatil(@RequestBody @Valid CustomerDto customerDto) {
		CustomerEntity customerDetail = serviceInterface.getCustomerDetail(customerDto);
		if (customerDetail != null) {
			ecomResponse.setMessage("customer detail get successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("customer details not get");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}

	@DeleteMapping("/deleteCustomerDetail")
	public ResponseEntity<EcomResponse> deleteCustomerDeatil(@RequestBody @Valid CustomerDto customerDto) {
		String deleteCustomerDetail = serviceInterface.deleteCustomerDetail(customerDto);
		if (deleteCustomerDetail != null) {
			ecomResponse.setMessage("customer detail get successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("customer details not get");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	//BILLING ADDRESS CONTROLLER
	
	@PostMapping("/createBillingAddress")
	public ResponseEntity<EcomResponse> createBillingAddress(@RequestBody @Valid BillingAddressDto billingAddressDto) {
		boolean billingAddress = serviceInterface.createBillingAddress(billingAddressDto);
		if (billingAddress == true) {
			ecomResponse.setMessage("billing address successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("billing address not saved");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	@PostMapping("/updateBillingAddress")
	public ResponseEntity<EcomResponse> updateBillingAddress(@RequestBody @Valid BillingAddressDto billingAddressDto) {
		BillingAdressEntity updateBillingAdress = serviceInterface.updateBillingAdress(billingAddressDto);
		if (updateBillingAdress!=null) {
			ecomResponse.setMessage("billing address saved successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("billing address not saved");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	@GetMapping("/getBillingAddress")
	public ResponseEntity<EcomResponse> getBillingAddress(@RequestBody @Valid BillingAddressDto billingAddressDto) {
		BillingAdressEntity billingAddress = serviceInterface.getBillingAddress(billingAddressDto);
		if (billingAddress!=null) {
			ecomResponse.setMessage("billing address get successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("billing address not saved");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	@DeleteMapping("/deleteBillingAddress")
	public ResponseEntity<EcomResponse> deleteBillingAddress(@RequestBody @Valid BillingAddressDto billingAddressDto) {
		String deleteBillingAddress = serviceInterface.deleteBillingAddress(billingAddressDto);
		if (deleteBillingAddress!=null) {
			ecomResponse.setMessage("billing address delete succefully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("billing address not deleted");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	//SHIPPING ADDRESS CONTROLLER
	
	@PostMapping("/createShippingAddress")
	public ResponseEntity<EcomResponse> createBillingAddress(@RequestBody @Valid ShippingAdressDto shippingAdressDto) {
		boolean createShippingAddress = serviceInterface.createShippingAddress(shippingAdressDto);
		if (createShippingAddress == true) {
			ecomResponse.setMessage("shipping address successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("shipping address not saved");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	@PostMapping("/updateShippingAddress")
	public ResponseEntity<EcomResponse> updateShippingAddress(@RequestBody @Valid ShippingAdressDto  shippingAdressDto) {
		ShippingAddressEntity updateShippingAddress = serviceInterface.updateShippingAddress(shippingAdressDto);
		if (updateShippingAddress!=null) {
			ecomResponse.setMessage("shipping address saved successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("shipping address not saved");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	@GetMapping("/getShippingAddress")
	public ResponseEntity<EcomResponse> getBillingAddress(@RequestBody @Valid ShippingAdressDto shippingAdressDto) {
		ShippingAddressEntity shippingAddress = serviceInterface.getShippingAddress(shippingAdressDto);
		if (shippingAddress!=null) {
			ecomResponse.setMessage("shipping address get successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("shipping address not saved");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
	@DeleteMapping("/deleteShippingAddress")
	public ResponseEntity<EcomResponse> deleteShippingAddress(@RequestBody @Valid ShippingAdressDto shippingAdressDto) {
		String deleteShippingAddress = serviceInterface.deleteShippingAddress(shippingAdressDto);
		if (deleteShippingAddress!=null) {
			ecomResponse.setMessage("shipping address delete succefully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("shipping address not deleted");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}
	
}
