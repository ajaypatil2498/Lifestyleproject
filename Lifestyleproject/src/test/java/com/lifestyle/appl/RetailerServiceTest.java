package com.lifestyle.appl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lifestyle.appl.services.RetailerService;


@SpringBootTest
public class RetailerServiceTest {
	@Autowired RetailerService retailerservice;
	
	
	@Test
	void testgetRetailerByUserId()
	{
		int userId=1054;
		int retailerIdExpected=4032;
		
	int retailerIdActual=retailerservice.getRetailerIdFromUserId(userId);
	assertEquals(retailerIdExpected, retailerIdActual);
	}

	@Test
	void testapproveRetailerById()
	{
		int retailerId=4031;
		String expectedOutput="Retailer with Id: "+retailerId+" is approved";
		String ActualOutput=retailerservice.approveRetailer(retailerId);
		assertEquals(expectedOutput, ActualOutput);
		
		
		
	}
	
	
}
