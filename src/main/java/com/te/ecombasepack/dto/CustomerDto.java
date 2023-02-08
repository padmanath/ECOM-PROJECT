package com.te.ecombasepack.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDto {

	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotNull
	private long customerPhone;
	
	
	
	
	

}
