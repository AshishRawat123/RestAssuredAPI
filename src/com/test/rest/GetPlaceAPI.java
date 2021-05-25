package com.test.rest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.GeoLocation;

public class GetPlaceAPI {
	
	private String placeID=null;
	
	@BeforeTest()
	public void before_Test() {
		RestAssured.baseURI = Constants.BaseURL;
	}
	
	
	// Already Created Place Pojo Class Use
	@Test()
	public void get_Place() {
		HashMap<String, String> addparam = Constants.getParam();
		addparam.put("place_id", "a0ebd6830f1058ba5140f38cbe44469b");
		GeoLocation loca = RestAssured.given().log().all()
		.queryParams(addparam)
		.when().get(Constants.GetResource).as(GeoLocation.class);
		
		Assert.assertEquals("My new house", loca.getName());
		
		
		
		

	}
	
	

}
