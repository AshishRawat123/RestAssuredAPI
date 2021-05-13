package com.test.rest;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import MockingResponse.MockingAPIResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TestMockingAPI {

	
	@Test()
	public void validate_Amount() {
		JsonPath jpath= new JsonPath(MockingAPIResponse.dummy_API());
		int course = jpath.getInt("courses.size()");
		ArrayList<String> alist =  new ArrayList<>(jpath.getList("courses['title']"));
		System.out.println("LIST OF COURSES");
		for(String s : alist)
			System.out.println(" "+s);
		System.out.println("Number of Courses :  "+course);
		int total_Amount=0;
		for(int i=0; i<course;i++) {	
			total_Amount = total_Amount +jpath.getInt("courses["+i+"].price")*jpath.getInt("courses["+i+"].copies");
		}
		System.out.println("Total calculated Amount  : "+total_Amount);
		System.out.println("Amount according to JSON  : "+jpath.getInt("dashboard.purchaseAmount"));
		Assert.assertEquals(total_Amount, jpath.getInt("dashboard.purchaseAmount"));
	}
	
	@Test()
	public void validate_ArrayResponse() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		String responseBody = RestAssured.given().log().all().queryParam("id", "1")
		.when().get()
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jp = new JsonPath(responseBody);
		System.out.println(jp.getString("[0].name"));
		Assert.assertEquals(jp.getString("[0].name"), "Leanne Graham");
	}
	
}
