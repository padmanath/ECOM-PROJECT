package com.te.ecombasepack.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecombasepack.dto.ProductDto;
import com.te.ecombasepack.entity.ProductEntity;
import com.te.ecombasepack.response.EcomResponse;
import com.te.ecombasepack.service.ServiceInterface;
import com.te.ecombasepack.serviceImpl.ServiceImplementation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthoritiesController {

	@Autowired
	private EcomResponse ecomResponse;

	
	private final ServiceInterface serviceInterface;
	
	

	@PostMapping("/createproducts")
	public ResponseEntity<EcomResponse> saveProduct(@RequestBody @Valid ProductDto productDto) {
		boolean product = serviceInterface.createProduct(productDto);
		if (product == true) {
			ecomResponse.setMessage("your product saved successfully ");
			ecomResponse.setStatus("200");
			

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("your product not saved ");
			ecomResponse.setStatus("400");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("/UpdateProduct")
	public ResponseEntity<EcomResponse> updateProduct(@RequestBody @Valid ProductDto productDto) {
		ProductEntity updateProduct = serviceInterface.updateProduct(productDto);
		if (updateProduct != null) {
			ecomResponse.setMessage("your product updated successfully ");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("update failed ");
			ecomResponse.setStatus("400");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}


		@GetMapping("/getAllProduct")
		public ResponseEntity<EcomResponse> getAllProduct() {
			List<ProductDto> allProductDetail = serviceInterface.getAllProductDetail();
			if (allProductDetail != null) {
				ecomResponse.setMessage("show request sucess");
				ecomResponse.setStatus("200");
                ecomResponse.setData(allProductDetail);
				return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

			} else {

				ecomResponse.setMessage("something went wrong ");
				ecomResponse.setStatus("400");

				return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

			}
		}
		
		

	@DeleteMapping("/deleteproduct")
	public ResponseEntity<EcomResponse> deleteProduct(@RequestBody @Valid ProductDto productDto) {
		String deleteProduct = serviceInterface.deleteProduct(productDto);

		if (deleteProduct != null) {
			ecomResponse.setMessage("product deleted sucessfully");
			ecomResponse.setStatus("200");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.ACCEPTED);

		} else {

			ecomResponse.setMessage("deleted failed ");
			ecomResponse.setStatus("400");

			return new ResponseEntity<EcomResponse>(ecomResponse, HttpStatus.BAD_REQUEST);

		}

	}

	
}
