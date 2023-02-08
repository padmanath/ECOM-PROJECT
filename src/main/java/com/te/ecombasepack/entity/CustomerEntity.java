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
import javax.validation.constraints.Pattern;

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

public class CustomerEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull           
	private long customerPhone;
	
	
	
	

	@OneToOne(targetEntity = ShippingAddressEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", name = "shippingId")
	private ShippingAddressEntity shippingAddressEntity;

	@OneToOne(targetEntity = BillingAdressEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", name = "billingId")
	private BillingAdressEntity billingAdressEntity;

	@OneToOne(targetEntity = RegisterEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", name = "userId")
	private RegisterEntity userEntity;

	@OneToOne(targetEntity = CartEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id", name = "cartId")
	private CartEntity cartEntity;

	
}
