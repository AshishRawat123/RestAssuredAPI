package com.test.rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class EndToEndTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Add GMap location
		//Adding Comment to Rebase
		
		String locationJson= "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Ashish house New 2\",\r\n" + 
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
		
		RestAssured.baseURI = Constants.BaseURL;
		String reponseBody =  RestAssured.given().log().all()
		.queryParams(Constants.getParam()).headers(Constants.modifyHeader()).body(locationJson)
		.when().post(Constants.PostResource)
		.then().log().all().extract().response().asString();
		
		System.out.println("Response Body is : "+reponseBody);
		
	
		
		//Delete The location on the Basis of place_id
		JsonPath jpath= new JsonPath(reponseBody);
		String place_id = jpath.getString("place_id");
		
		// TODO Get the Update Address
		String getResponse = RestAssured.given().log().all().queryParams(Constants.getParam()).queryParam("place_id", place_id)
				.when().get(Constants.GetResource)
				.then().log().all().extract().response().asString();
		System.out.println("GET location Latitude  : "+new JsonPath(getResponse).getString("location.latitude"));
		
		//TODO Update Address	
		String updateAddressjson = "{\r\n" + 
				"			\"place_id\":\""+place_id+"\",\r\n" + 
				"			\"address\":\"70 Summer walk, USA\",\r\n" + 
				"			\"key\":\"qaclick123\"\r\n" + 
				"			}";
		
		String updateData =new JsonPath(RestAssured.given().log().all().queryParams(Constants.getParam()).headers(Constants.modifyHeader()).body(updateAddressjson)
		.when().put(Constants.PutResource)
		.then().log().all().extract().response().asString()).getString("msg");
		System.out.println("Update Message  :  "+updateData);

		
		//Delete The location on the Basis of place_id
		String deleteJson = "{\r\n" + 
				"    \"place_id\":\""+place_id+"\"\r\n" + 
				"}\r\n" + 
				"";
		
		RestAssured.given().log().all()
		.queryParams(Constants.getParam()).headers(Constants.modifyHeader()).body(deleteJson)
		.when().delete(Constants.DeleteResource)
		.then().log().all();

	}

}
