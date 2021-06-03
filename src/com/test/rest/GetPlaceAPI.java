package com.test.rest;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.Utils.Util;

import io.restassured.RestAssured;
import pojo.GeoLocation2;

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
		GeoLocation2 loca = RestAssured.given().log().all()
		.queryParams(addparam)
		.when().get(Constants.GetResource).as(GeoLocation2.class);
		
		Assert.assertEquals("My new house", loca.getName());	

	}
	
	@Test
	public void loggin_API() throws FileNotFoundException {
		 GeoLocation2 loc = RestAssured.given(Util.request_Spec_Builder(null)).when().get(Constants.GetResource).as(GeoLocation2.class);
		
		Assert.assertEquals("My new house", loc.getName());
	}
	

}
