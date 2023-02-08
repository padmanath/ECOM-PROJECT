package com.te.ecombasepack.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecombasepack.dto.CartIteamDto;
import com.te.ecombasepack.dto.CustomerDto;
import com.te.ecombasepack.dto.ProductDto;
import com.te.ecombasepack.entity.CartEntity;
import com.te.ecombasepack.entity.CartIteamEntity;
import com.te.ecombasepack.response.EcomResponse;
import com.te.ecombasepack.service.ServiceInterface;
import com.te.ecombasepack.serviceImpl.ServiceImplementation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CartIteamController {

	
	private final ServiceInterface serviceInterface;

	@Autowired
	private EcomResponse ecomResponse;

	@PostMapping("/addQuantityCartIteam")
	public ResponseEntity<EcomResponse> addCartIteam(@RequestBody @Valid CartIteamDto cartIteamDto) {
		CartIteamEntity addCartIteam = serviceInterface.addCartIteam(cartIteamDto);

		if (addCartIteam != null) {
			ecomResponse.setMessage("your iteam add successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("your iteam not add ");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/addPriceCartIteam")
	public ResponseEntity<EcomResponse> addPriceCartIteam(@RequestBody @Valid CustomerDto customerDto) {
		CartEntity addTotalPriceCartIteam = serviceInterface.addTotalPriceCartIteam(customerDto);

		if (addTotalPriceCartIteam != null) {
			ecomResponse.setMessage("your price is ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("your price not add ");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/removeCartIteam")
	public ResponseEntity<EcomResponse> removeCartIteam(@RequestBody @Valid CartIteamDto cartIteamDto) {
		String removeCartIteam = serviceInterface.removeCartIteam(cartIteamDto);

		if (removeCartIteam != null) {
			ecomResponse.setMessage("your iteam removed successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("your iteam not removed ");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/removeAllCartIteam")
	public ResponseEntity<EcomResponse> removeAllCartIteam(@RequestBody @Valid CartIteamDto cartIteamDto) {
		String removeAllIteam = serviceInterface.removeAllIteam(cartIteamDto);

		if (removeAllIteam != null) {
			ecomResponse.setMessage("your All iteam removed successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("your All iteam not removed ");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}

}
