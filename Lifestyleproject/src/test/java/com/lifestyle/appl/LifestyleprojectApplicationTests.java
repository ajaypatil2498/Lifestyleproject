package com.lifestyle.appl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lifestyle.appl.beans.User;
import com.lifestyle.appl.services.RetailerService;
import com.lifestyle.appl.services.UserService;

@SpringBootTest
class LifestyleprojectApplicationTests {

	
	@Autowired UserService userservice;
	
	@Test
	void contextLoads() {
	}
	
	
	

}
