package com.test.rest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UseTestNG {
	
	public String placeID=null;
	
	@BeforeTest()
	public void before_Test() {
		RestAssured.baseURI = Constants.BaseURL;
		System.out.println("Null should be prinrted     "+placeID);
	}
	
	@Test()
	public void add_Place() {
		String locationJson= "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Ashish house New 222\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
		String responseBody = RestAssured.given().log().all()
		.queryParams(Constants.getParam()).headers(Constants.modifyHeader()).body(locationJson)
		.when().post(Constants.PostResource)
		.then().log().all().extract().response().asString();
		placeID = GetJsonPathValue.getValue_From_Response("place_id", responseBody);
		System.out.println("PLace ID is "+placeID);
		Assert.assertNotEquals(placeID, null);
	}
	
	@Test()
	public void delete_Place() {
		String deleteJson = "{\r\n" + 
				"    \"place_id\":\""+placeID+"\"\r\n" + 
				"}\r\n" + 
				"";		
		String responseBody = RestAssured.given().log().all()
		.queryParams(Constants.getParam()).headers(Constants.modifyHeader()).body(deleteJson)
		.when().delete(Constants.DeleteResource)
		.then().log().all().extract().response().asString();
		String Status = GetJsonPathValue.getValue_From_Response("status", responseBody);
		Assert.assertEquals(Status, "OK");
		
	}

}
