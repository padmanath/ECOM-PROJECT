package com.te.ecombasepack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="RegisterEntity")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegisterEntity {
	@Id
	@GeneratedValue
	private int id;
	
	@Email(message = "invalid email id")
	private String emailId;
	
	@NotNull
	private String password;


	

	
}
