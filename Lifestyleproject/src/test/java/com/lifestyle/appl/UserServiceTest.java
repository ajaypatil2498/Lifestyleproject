package com.lifestyle.appl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lifestyle.appl.beans.User;
import com.lifestyle.appl.services.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired UserService userservice;
	@Test
	void testfetchUserByEmailId()
	{
		int userId=1050;
		String emailId="akshaybharati991@gmail.com";
		User user=userservice.fetchUserByEmailId(emailId);
		assertEquals(userId, user.getUserId());
		
	}
	@Test
	void testfetchUserByEmailIdAndPassword()
	{
		int userid=1050;
		String emailId="akshaybharati991@gmail.com";
		String password="Akshay@991";
		User user=userservice.fetchUserByEmailIdAndPassword(emailId, password);
		assertEquals(userid, user.getUserId());
	}
}
