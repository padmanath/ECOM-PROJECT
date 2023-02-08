//package com.te.emp.ecombasepack.register;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.te.ecombasepack.entity.RegisterEntity;
//import com.te.ecombasepack.repository.RegisterRepository;
//
//@DataJpaTest
//public class RegisterRepositoryTest {
//
//	
//	@Autowired
//	private RegisterRepository underTest;
//	
//	@Test
//	void itShouldCheckRegisterApi() {
//	//given
//		 RegisterEntity registerEntity = new RegisterEntity(01,"pad@123","pass123");
//		
//
//		underTest.save(registerEntity);
//		//when		
//	    Boolean expected = underTest.findByEmailId("pad@123");
//	    //then
//	    assertThat(expected).isTrue();
//	}
//	
//	
//}
