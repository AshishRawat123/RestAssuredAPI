package com.test.rest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;

public class TestMyAPI {
	
	
	@BeforeTest()
	public void beforeTest() {
//		RestAssured.baseURI =baseURI;
	}
	
//	@Test()
//	public void myGET() {
////			RestAssured.basePath ="users";
//			RestAssured.given().when().get().then().assertThat().statusCode(200).body("[0].id",equalTo(1));
//	}
	
	@Test(enabled=false)
	public void secPOST() {
//		RestAssured.baseURI= "https://chercher.tech/sample/api/product/update.php";
		//		RestAssured.basePath="/update.php";
		HashMap<String, String> postContent = new HashMap<>();
		postContent.put("id","4508");
		postContent.put("name","Ashish RAWAT");
		postContent.put("description","Hello Rawat ji");
		postContent.put("price","122");	
		RestAssured.given().log().all().contentType(ContentType.JSON).body(postContent).when().post("https://chercher.tech/sample/api/product/update.php").asPrettyString();

	}
	
	@Test()
	public void getUserDetails() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		HashMap<String, String> getContent = new HashMap<String, String>();
		getContent.put("id", "1");
		Response rs = RestAssured.given().when().params(getContent).get();
		JsonPath jsonPathEvaluator = rs.jsonPath();
		System.out.println(jsonPathEvaluator.getString("[0].name"));
	}
	
	@Test()
	public void postUserDetails() {
		
		RestAssured.baseURI="https://chercher.tech/sample/api/product";
		HashMap<String, String> postContent = new HashMap<>();
		postContent.put("id","4505");
		postContent.put("name","Ashish RAWAT");
		postContent.put("description","Hello Rawat ji");
		postContent.put("price","122");
		Response postRes = RestAssured.given().contentType(ContentType.JSON).body(postContent).put("update.php");
		System.out.println(postRes.asPrettyString());
	}
	
	@Test()
	public void deleteUser() {
		
		RestAssured.baseURI="https://chercher.tech/sample/api/product";
		HashMap<String, String> postContent = new HashMap<>();
		postContent.put("id","4504");
		Response postRes = RestAssured.given().contentType(ContentType.JSON).body(postContent).delete("delete.php");
		System.out.println(postRes.asPrettyString());
	}
	
	
	

}
