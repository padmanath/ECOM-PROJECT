package com.te.ecombasepack.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

public class ProductEntity {
	
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
	
	
	

//	@OneToOne(targetEntity = CartIteamEntity.class,cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "id",name = "cartiteamId")
//	private CartIteamEntity cartIteamEntity;
	
	
	

}
