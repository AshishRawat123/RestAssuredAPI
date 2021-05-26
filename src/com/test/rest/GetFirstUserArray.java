package com.test.rest;

import org.testng.Assert;
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
		Assert.assertEquals(hr[0].getName(), "Leanne Graham");
		Assert.assertEquals(hr[0].getEmail(),"Sincere@april.biz");
		Assert.assertEquals(hr[0].getCompany().getName(),"Romaguera-Crona");
		Assert.assertEquals(hr[0].getAddress().getCity(),"Gwenborough");
				
	}

}
