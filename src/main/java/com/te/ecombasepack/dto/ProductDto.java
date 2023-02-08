package com.te.ecombasepack.dto;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.ecombasepack.entity.RegisterEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@RequestMapping
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    
	@Id
	@GeneratedValue
	@NotNull
	private int id;
	
	@NotNull
    private String category;
    
    @NotNull
	private String description;
	
	@NotNull
	private String manufacturer;
	
	@NotNull
	private String name;
	
	@NotNull
	private long price;
	
	@NotNull
	private long unit;
	
	
	
	
	
	
}
