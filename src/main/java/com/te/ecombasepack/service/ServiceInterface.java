package com.te.ecombasepack.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.te.ecombasepack.dto.BillingAddressDto;
import com.te.ecombasepack.dto.CartDto;
import com.te.ecombasepack.dto.CartIteamDto;
import com.te.ecombasepack.dto.CustomerDto;
import com.te.ecombasepack.dto.ProductDto;
import com.te.ecombasepack.dto.ShippingAdressDto;
import com.te.ecombasepack.entity.BillingAdressEntity;
import com.te.ecombasepack.entity.CartEntity;
import com.te.ecombasepack.entity.CartIteamEntity;
import com.te.ecombasepack.entity.CustomerEntity;
import com.te.ecombasepack.entity.ProductEntity;
import com.te.ecombasepack.entity.RegisterEntity;
import com.te.ecombasepack.entity.ShippingAddressEntity;

public interface ServiceInterface {

	// REGISTER
	public boolean register(RegisterEntity registerEntity);

	// PRODUCT CURD OPERATION

	public boolean createProduct(ProductDto productDto);

	ProductEntity updateProduct(ProductDto productDto);

	String deleteProduct(ProductDto productDto);
	
	//Get particullar

	// GET ALL PRODUCT
	public List<ProductDto> getAllProductDetail();
	
	

	// CUSTOMER CURD OPERATION
	public boolean createCustomerDetail(CustomerDto customerDto);

	CustomerEntity updateCustomerDetail(CustomerDto customerDto);

	CustomerEntity getCustomerDetail(CustomerDto customerDto);

	String deleteCustomerDetail(CustomerDto customerDto);
	
	

	// CART RELATED OPERATION

	public CartIteamEntity addCartIteam(CartIteamDto cartIteamDto);

	public String removeCartIteam(CartIteamDto cartIteamDto);

	public String removeAllIteam(CartIteamDto cartIteamDto);
	
	

	// TOTAL PRICE CALCULATION
	public CartEntity addTotalPriceCartIteam(CustomerDto customerDto);

//	List<CartIteamDto> addPriceCartIteam(ProductDto productDto);
	
	

	// BILLING ADDRESS CURD OPERATION

	public boolean createBillingAddress(BillingAddressDto billingAddressDto);

	BillingAdressEntity updateBillingAdress(BillingAddressDto billingAddressDto);

	BillingAdressEntity getBillingAddress(BillingAddressDto billingAddressDto);

	String deleteBillingAddress(BillingAddressDto billingAddressDto);
	
	

	// ShIPPING ADDRESS CURD OPERATION
	public boolean createShippingAddress(ShippingAdressDto shippingAdressDto);

	ShippingAddressEntity updateShippingAddress(ShippingAdressDto shippingAdressDto);

	ShippingAddressEntity getShippingAddress(ShippingAdressDto shippingAdressDto);

	String deleteShippingAddress(ShippingAdressDto shippingAdressDto);

}
