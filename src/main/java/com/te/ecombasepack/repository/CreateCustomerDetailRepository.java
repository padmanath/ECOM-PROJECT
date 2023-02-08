package com.te.ecombasepack.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecombasepack.entity.CustomerEntity;

@Repository
public interface CreateCustomerDetailRepository extends JpaRepository<CustomerEntity, Integer> {

	
	
}
