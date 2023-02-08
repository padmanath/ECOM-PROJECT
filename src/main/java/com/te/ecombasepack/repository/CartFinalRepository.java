package com.te.ecombasepack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecombasepack.entity.CartEntity;

@Repository
public interface CartFinalRepository extends JpaRepository<CartEntity, Integer> {
	
	

	
}
