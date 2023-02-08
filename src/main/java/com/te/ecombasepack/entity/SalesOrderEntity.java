package com.te.ecombasepack.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

public class SalesOrderEntity {
	@Id
	@GeneratedValue
	private int id;
//	private String cartId;
//	private String customerId;
//	private String shippingAdressId;
//	private String billingAdressId;

	@OneToOne(targetEntity = ShippingAddressEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id",name = "shippingId")
	private ShippingAddressEntity shippingAddressEntity;

	@OneToOne(targetEntity = BillingAdressEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id",name = "billingId")
	private BillingAdressEntity billingAdressEntity;

	@OneToOne(targetEntity = CartEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id",name = "cartId")
	private CartEntity cartEntity;

	@OneToOne(targetEntity = CustomerEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id",name = "customerId")
	private CustomerEntity customerEntity;

	

}
