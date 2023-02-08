package com.te.ecombasepack.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.te.ecombasepack.entity.RegisterEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BillingAddressDto {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String address;
	@NotEmpty
	private String city;
	@NotNull
	private long zipcode;
	@NotBlank
	private String country;
	

	

}
