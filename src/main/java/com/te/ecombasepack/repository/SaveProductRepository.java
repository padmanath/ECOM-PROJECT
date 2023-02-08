package com.te.ecombasepack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecombasepack.entity.ProductEntity;

@Repository
public interface SaveProductRepository extends JpaRepository<ProductEntity, Integer> {

}
