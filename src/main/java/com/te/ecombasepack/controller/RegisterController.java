package com.te.ecombasepack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecombasepack.entity.RegisterEntity;
import com.te.ecombasepack.response.EcomResponse;
import com.te.ecombasepack.service.ServiceInterface;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegisterController {

	@Autowired
	private EcomResponse ecomResponse;


	private ServiceInterface serviceInterface;

	@PostMapping("/registeration")
	private ResponseEntity<EcomResponse> register(@RequestBody @Valid RegisterEntity registerEntity) {

		boolean register = serviceInterface.register(registerEntity);
		if (register == true) {
			ecomResponse.setMessage("your registeration successfully done");
			ecomResponse.setStatus("200");
           
			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("your registeration failed");
			ecomResponse.setStatus("500");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}

}
