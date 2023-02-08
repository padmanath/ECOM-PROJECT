package com.te.ecombasepack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecombasepack.entity.RegisterEntity;


@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {
      
//	Boolean findByEmailId(String emailId);
	
	
}
