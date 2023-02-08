package com.te.ecombasepack.serviceImpl;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.te.ecombasepack.exception.BillingAddressException;
import com.te.ecombasepack.exception.CartIteamException;
import com.te.ecombasepack.exception.CustomerException;
import com.te.ecombasepack.exception.ProductException;
import com.te.ecombasepack.exception.ShippingAddressException;
import com.te.ecombasepack.repository.SaveProductRepository;
import com.te.ecombasepack.repository.CartFinalRepository;
import com.te.ecombasepack.repository.CartIteamRepository;
import com.te.ecombasepack.repository.CartRepository;
import com.te.ecombasepack.repository.CreateBillingAddressRepository;
import com.te.ecombasepack.repository.CreateCustomerDetailRepository;
import com.te.ecombasepack.repository.CreateShippingAddressRepository;
import com.te.ecombasepack.repository.ProductRepository;
import com.te.ecombasepack.repository.RegisterRepository;

import com.te.ecombasepack.service.ServiceInterface;

@Service
public class ServiceImplementation implements ServiceInterface  {

	// REPOSITORY
	@Autowired
	private CartFinalRepository cartFinalRepository;
	@Autowired
	private RegisterRepository registerRepository;
	@Autowired
	private SaveProductRepository saveproductRepository;
	@Autowired
	private CreateCustomerDetailRepository createCustomerDetailRepository;
	@Autowired
	private CreateBillingAddressRepository createBillingAddressRepository;
	@Autowired
	private CreateShippingAddressRepository createShippingAddressRepository;
	@Autowired
	private CartIteamRepository cartIteamRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;

	// ENTITY
	@Autowired
	private ProductEntity productEntity;
	@Autowired
	private CustomerEntity customerEntity;
	@Autowired
	private BillingAdressEntity billingAdressEntity;
	@Autowired
	private ShippingAddressEntity shippingAddressEntity;
	@Autowired
	private CartIteamEntity cartIteamEntity;
	@Autowired
	private CartEntity cartEntity;

	//DTO
	@Autowired
	private CartIteamDto cartIteamDto;
	@Autowired
	private CartDto cartDto;
	@Autowired
	private CustomerDto customerDto;
	
	
	
	////////////////////////////////////////////////////////// REGISTOR RELATED API////////////////////////////////////////////////////////////
	

	@Override
	public boolean register(RegisterEntity registerEntity) {

		if (registerEntity != null) {
			registerRepository.save(registerEntity);
			return true;
		} else {

			return false;
		}
	}

	///////////////////////////////////////////////// PRODUCT CURD OPERATION API///////////////////////////////////////////////////////////////
	

	@Override
	public boolean createProduct(ProductDto productDto) {
		BeanUtils.copyProperties(productDto, productEntity);
		ProductEntity repository = saveproductRepository.save(productEntity);
		if (repository != null) {
			return true;
		} else

			throw new ProductException("product not saved");
	}

	@Override
	public ProductEntity updateProduct(ProductDto productDto) {

		ProductEntity updateProduct = saveproductRepository.findById(productDto.getId()).get();
		
		
		productEntity.setId(productDto.getId());
		productEntity.setName(productDto.getName());
     	productEntity.setCategory(productDto.getCategory());                                  //INSTED OF USING SET VALUE, WE USE LOMBOK CONSTRUCTOR FROM PARTICULAR ENTITY IN BUILD METHOD TO SET        
    	productEntity.setDescription(productDto.getDescription());
		productEntity.setManufacturer(productDto.getManufacturer());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setUnit(productDto.getUnit());
		BeanUtils.copyProperties(productDto, updateProduct);

		if (updateProduct != null) {
			saveproductRepository.save(updateProduct);
			return updateProduct;
		}

		throw new ProductException("product not updated is of null");
	}

	@Override
	public List<ProductDto> getAllProductDetail() {
		List<ProductEntity> findAll = saveproductRepository.findAll();
		List<ProductDto> collect = findAll.stream().map(e -> {
			ProductDto productDto2 = new ProductDto();
			BeanUtils.copyProperties(e, productDto2);
			return productDto2;

		}).collect(Collectors.toList());
		return collect;
	}

	@Override
	public String deleteProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(productDto, productEntity);
		try {
			saveproductRepository.deleteById(productEntity.getId());
			return "op done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
/////////////////////////////////////////////////////// CUSTOMER CURD OPERATION/////////////////////////////////////////////////////////////////////

	@Override
	public boolean createCustomerDetail(CustomerDto customerDto) {
// TODO Auto-generated method stub
		BeanUtils.copyProperties(customerDto, customerEntity);
		customerEntity.setId(customerDto.getId());
		customerEntity.setFirstName(customerDto.getFirstName());
		customerEntity.setLastName(customerDto.getLastName());
		customerEntity.setCustomerPhone(customerDto.getCustomerPhone());

		CustomerEntity customer = createCustomerDetailRepository.save(customerEntity);
		if (customer != null) {
			return true;
		} else
			throw new ProductException("customer not created");
	}

	@Override
	public CustomerEntity updateCustomerDetail(CustomerDto customerDto) {
// TODO Auto-generated method stub
		BeanUtils.copyProperties(customerDto, customerEntity);
		customerEntity.setId(customerDto.getId());
		customerEntity.setFirstName(customerDto.getFirstName());                        //INSTED OF USING SET VALUE, WE USE LOMBOK CONSTRUCTOR FROM PARTICULAR ENTITY IN BUILD METHOD TO SET
		customerEntity.setLastName(customerDto.getLastName());
		customerEntity.setCustomerPhone(customerDto.getCustomerPhone());

		if (customerEntity != null) {
			createCustomerDetailRepository.save(customerEntity);
			return customerEntity;
		} else {
			throw new ProductException("customer not updated");
		}

	}

	@Override
	public CustomerEntity getCustomerDetail(CustomerDto customerDto) {
// TODO Auto-generated method stub
		BeanUtils.copyProperties(customerDto, customerEntity);
		CustomerEntity customer = createCustomerDetailRepository.findById(customerEntity.getId())
				.orElseThrow(() -> new CustomerException("something went wrong"));
		return customer;
	}

	@Override
	public String deleteCustomerDetail(CustomerDto customerDto) {
// TODO Auto-generated method stub
		BeanUtils.copyProperties(customerDto, customerEntity);
		createCustomerDetailRepository.deleteById(customerEntity.getId());
		return "delete sucess";
	}

	/////////////////////////////////////////////////////////////// CART RELATED API//////////////////////////////////////////////////////////
	
	@Override
	public CartIteamEntity addCartIteam(CartIteamDto cartIteamDto) {
		BeanUtils.copyProperties(cartIteamDto, productEntity);
		ProductEntity product = productRepository.findById(productEntity.getId())
				.orElseThrow(() -> new ProductException("products not found"));
//		BeanUtils.copyProperties(product, cartIteamEntity);
		cartIteamEntity.setQuantity(cartIteamDto.getQuantity());
		
		cartIteamEntity.setPrice(product.getPrice() * cartIteamDto.getQuantity());
		CartIteamEntity cartIteam = cartIteamRepository.save(cartIteamEntity);
		
		
		if (cartIteam != null) {
			return cartIteam;
		} else {

			throw new CartIteamException("Cart not created");

		}

	}

	@Override
	public String removeCartIteam(CartIteamDto cartIteamDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(cartIteamDto, cartIteamEntity);
		cartIteamRepository.deleteById(cartIteamEntity.getId());

		throw new CartIteamException("null", "deleted successfully");     
	}

	@Override
	public String removeAllIteam(CartIteamDto cartIteamDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(cartIteamDto, cartIteamEntity);
		cartIteamRepository.deleteAll();
		return "removed sucess";
	}

/////////////////////////////////////////////////////////////// PRICE CALCULATION API//////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public CartEntity addTotalPriceCartIteam(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
		List<Double> findAll = cartIteamRepository.findAll().stream().filter(cartCreated -> cartCreated.getPrice() > 0)
				.map(CartIteamEntity::getPrice).collect(Collectors.toList());
		Double TotalPrice = 0.0;
		for (Double total : findAll) {
			TotalPrice += total;
		}
		cartEntity.setId(customerDto.getId());
		cartEntity.setTotalPrice(TotalPrice);
		CartEntity entity = cartFinalRepository.save(cartEntity);

		return entity;
	}

//	@Override
//	public List<CartIteamDto> addQuantityCartIteam(ProductDto productDto) {
//		// TODO Auto-generated method stub
//		ProductEntity entity = saveproductRepository.findById(productEntity.getId())
//				.orElseThrow(() -> new CartIteamException("something went wrong"));
//		BeanUtils.copyProperties(entity, productDto);
//		cartIteamEntity.getQuantity().add(productDto);
//		cartIteamRepository.save(cartIteamEntity);
//		List<CartIteamEntity> findAll = cartIteamRepository.findAll();
//		List<CartIteamDto> collect = findAll.stream().map(e -> {
//			BeanUtils.copyProperties(e, cartIteamDto);
//			return cartIteamDto;
//		}).collect(Collectors.toList());
//		return collect;
//
//	}
//	

//	@Override
//	public List<CartIteamDto> addPriceCartIteam(ProductDto productDto) {
//		// TODO Auto-generated method stub
//		ProductEntity product = saveproductRepository.findById(productEntity.getId())
//				.orElseThrow(() -> new ProductException("something went wrong"));
//		long price = product.getPrice();
//		cartIteamEntity.getPrice().add(price);
//		cartIteamRepository.save(cartIteamEntity);
//		List<CartIteamEntity> findAll = cartIteamRepository.findAll();
//		List<CartIteamDto> collect = findAll.stream().map(e -> {
//			BeanUtils.copyProperties(e, cartIteamDto);
//			return cartIteamDto;
//		}).collect(Collectors.toList());
//		return collect;
//
	
	
	
	

	///////////////////////////////////////////////////////////////// BILLING ADDRESS CURD OPERATION/////////////////////////////////////////////////////////
	

	@Override
	public boolean createBillingAddress(BillingAddressDto billingAddressDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(billingAddressDto, billingAdressEntity);
		billingAdressEntity.setId(billingAddressDto.getId());
		billingAdressEntity.setAddress(billingAddressDto.getAddress());
		billingAdressEntity.setCity(billingAddressDto.getCity());
		billingAdressEntity.setCountry(billingAddressDto.getCountry());
		billingAdressEntity.setZipcode(billingAddressDto.getZipcode());

		BillingAdressEntity billingAdress = createBillingAddressRepository.save(billingAdressEntity);
		if (billingAdress != null) {
			return true;
		} else

			throw new BillingAddressException("Billing Address not created ");

	}

	@Override
	public BillingAdressEntity updateBillingAdress(BillingAddressDto billingAddressDto) {
		// TODO Auto-generated method stub
		
		BillingAdressEntity billingAdressEntity = createBillingAddressRepository.findById(billingAddressDto.getId()).orElse(null);
//		billingAdressEntity.setId(billingAddressDto.getId());
		BeanUtils.copyProperties(billingAddressDto, billingAdressEntity);
//		billingAdressEntity.setAddress(billingAddressDto.getAddress());
//		billingAdressEntity.setCity(billingAddressDto.getCity());
//		billingAdressEntity.setCountry(billingAddressDto.getCountry());
//		billingAdressEntity.setZipcode(billingAddressDto.getZipcode());

		if (billingAdressEntity != null) {

			BillingAdressEntity billingAddress = createBillingAddressRepository.save(billingAdressEntity);
			return billingAddress;
		}

		throw new BillingAddressException("Billing Address not created ");

	}

	@Override
	public BillingAdressEntity getBillingAddress(BillingAddressDto billingAddressDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(billingAddressDto, billingAdressEntity);
		BillingAdressEntity billingAdress = createBillingAddressRepository.findById(billingAdressEntity.getId())
				.orElseThrow(() -> new BillingAddressException("something went wrong"));
		return billingAdress;
	}

	@Override
	public String deleteBillingAddress(BillingAddressDto billingAddressDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(billingAddressDto, billingAdressEntity);
		createBillingAddressRepository.deleteById(billingAdressEntity.getId());
		return "billing address delete sucess";
	}
	
	
	

///////////////////////////////////////////////////////////////// SHIPPING ADDRESS CURD OPERATION/////////////////////////////////////////////////////////
	
	@Override
	public boolean createShippingAddress(ShippingAdressDto shippingAdressDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(shippingAdressDto, shippingAddressEntity);
		shippingAddressEntity.setId(shippingAdressDto.getId());
		shippingAddressEntity.setAddress(shippingAdressDto.getAddress());
		shippingAddressEntity.setCity(shippingAdressDto.getCity());
		shippingAddressEntity.setCountry(shippingAdressDto.getCountry());
		shippingAddressEntity.setZipcode(shippingAdressDto.getZipcode());

		ShippingAddressEntity shippingaddress = createShippingAddressRepository.save(shippingAddressEntity);
		if (shippingaddress != null) {
			return true;
		} else

			throw new ShippingAddressException("shippingAdress not created");
	}

	@Override
	public ShippingAddressEntity updateShippingAddress(ShippingAdressDto shippingAdressDto) {
		// TODO Auto-generated method stub
		ShippingAddressEntity shippingAddressEntity = createShippingAddressRepository.findById(shippingAdressDto.getId()).orElse(null);
//		BeanUtils.copyProperties(shippingAdressDto, shippingAddressEntity);
//		shippingAddressEntity.setId(shippingAdressDto.getId());
//		shippingAddressEntity.setAddress(shippingAdressDto.getAddress());
//		shippingAddressEntity.setCity(shippingAdressDto.getCity());
//		shippingAddressEntity.setCountry(shippingAdressDto.getCountry());
//		shippingAddressEntity.setZipcode(shippingAdressDto.getZipcode());

		if (shippingAddressEntity != null) {

			ShippingAddressEntity shippingAddress = createShippingAddressRepository.save(shippingAddressEntity);
			return shippingAddress;
		} else {

			throw new ShippingAddressException("shippingAdress not updated");
		}
	}

	@Override
	public ShippingAddressEntity getShippingAddress(ShippingAdressDto shippingAdressDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(shippingAdressDto, shippingAddressEntity);
		ShippingAddressEntity shippingAddress = createShippingAddressRepository.findById(billingAdressEntity.getId())
				.orElseThrow(() -> new ShippingAddressException("something went wrong"));
		return shippingAddress;
	}

	@Override
	public String deleteShippingAddress(ShippingAdressDto shippingAdressDto) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(shippingAdressDto, shippingAddressEntity);
		createShippingAddressRepository.deleteById(shippingAddressEntity.getId());
		return "shipping address deleted sucessfully";
	}
	
	
}
