package com.te.ecombasepack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BillingAdressEntity {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull
	private long zipcode;
	@NotNull
	private String country;
	
	
	
	

	
}
