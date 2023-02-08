package com.te.ecombasepack.dto;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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

public class CartIteamDto {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private int quantity;
	@NotNull
	private double  price;
	
	@NotNull
    private String category;
    
    @NotNull
	private String description;
	
	@NotNull
	private String manufacturer;
	
	@NotNull(message="product shoud not be null")
	private String name;

	

	
	
	
	

	
	
	
	

	}
