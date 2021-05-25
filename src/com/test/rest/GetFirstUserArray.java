package com.test.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.UserDetails;

public class GetFirstUserArray {
	
	/* Way how to put the Response when We get Array in response instead of JSON
	 * Means JSON inside a Array
	 * */
	@Test()
	public void get_ArrayResponse() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		UserDetails[] hr = RestAssured.given().queryParam("id", "1")
		.when().get().as(UserDetails[].class);
		
		System.out.println("USER NAME "+hr[0].getName());
		System.out.println("USER EMAIL "+hr[0].getEmail());
		System.out.println("COMAPNY DETAILS  "+hr[0].getCompany().getName());
		System.out.println("COMAPNY DETAILS  "+hr[0].getAddress().getCity());
				
	}

}
