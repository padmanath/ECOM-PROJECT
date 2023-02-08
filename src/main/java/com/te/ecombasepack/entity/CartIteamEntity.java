package com.te.ecombasepack.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Component
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartIteamEntity {
	
	
//	private List<Object> quantity;
//	@NotNull
//	private List<Object> price;
//	private List<Product> product;
//	private String cartId;
//	private String productId;
	
	
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

	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CartEntity cart;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<ProductEntity> productEntities;
	
	

	
	

	
	
	

}
