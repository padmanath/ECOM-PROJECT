package com.te.ecombasepack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.ecombasepack.entity.ShippingAddressEntity;

public interface CreateShippingAddressRepository extends JpaRepository<ShippingAddressEntity, Integer> {

}
