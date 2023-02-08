package com.te.ecombasepack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

public class AuthoritiesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int id;
	
	@NotNull
	private String emailId;
	
	@NotNull
	private String authorities;

	

	

}
