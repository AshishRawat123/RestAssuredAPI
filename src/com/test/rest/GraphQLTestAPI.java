package com.test.rest;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class GraphQLTestAPI {
	
	
	
	@BeforeTest()
	public void before_Test() {
		RestAssured.baseURI = "https://hasura.io/learn/graphql";
	}
	
	@Test()
	public void get_Users_Limited_Details() {
		
		HashMap<String, String> headerHMap = new HashMap<>();
		//Generate your Own Key by signing up to hasura.io
		headerHMap.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2h"
				+ "hc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYwZDAyYj"
				+ "JlNWEyMzc3MDA2YTdhOGVlMyJ9LCJuaWNrbmFtZSI6ImFzaGlzaHJhd2F0MTkxMSIsIm5hbWUiOiJhc2hpc2hyYXdhdDE5MTFAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20v"
				+ "YXZhdGFyL2ZmY2MxNWQzMzI5MWJiOWVlODQ1ODFjZTVhNTUwZDE1P3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGYXMucG5nIiwidXBkYXRlZF9hdCI6IjIwMjE"
				+ "tMDYtMjFUMDY6MDE6MTkuNjE3WiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDYwZDAyYjJlNWEyMzc3MDA2YTdhOGVlMyIsImF1ZCI6IlAzOHFuRm"
				+ "8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNjI0MjU1MjgxLCJleHAiOjE2MjQyOTEyODEsImF0X2hhc2giOiJ6RzJjVXJHakpHYy1jbFdEdmRPTjBBIiwibm9uY2UiOiJOZGR3fjlTS2RqVjBHR0t"
				+ "taX5feWY2YXdPMG1YeHVoSCJ9.VOMyFTW1JOEazMBgG69-gndTEn5UH2PSWU9KXmb0Npw2QO42GgRdFUGto6KjxTM4GOKp8VJCCM0DcIwsqome7CWMrb2TWU85xGcAO5ZryEpwlZQQuiCjg7-nvJu4m_tr8V8b3r-_"
				+ "D39KLtLCrY25npWWa6LwFI0OjEem-l1wOFKqcKn3VId31lgM7R2G8OYZLFjcAydBv5D1RVANYplZ-_KrNX9McezjLJ2aB81uH7ePj2Bl1worXyC9kVbIDO7GGMFstdCC7bKOxBqMPhZAe1olrb3Knjce0o1XLPwwZg"
				+ "J3PtXu4foGumMZMYFhPr72L6G6Ucm6-SGXPSp4UX9Rdw");	
		String responseString =  RestAssured.given().log().all().headers(headerHMap).contentType(ContentType.JSON).
		when().body("{\"query\":\"{\\n  online_users {\\n    id\\n  }\\n}\\n\",\"variables\":null}").post().asString();

		//Assertion to Check the email ID is present
		Assert.assertEquals(JsonPath.from(responseString).getString("data.online_users.id[1]"), "test321@gmail.com");
		
		List<Object> le = JsonPath.from(responseString).getList("data.online_users.id");
		SoftAssert softy = new SoftAssert();
		
		// Validate the Email ID
		for(Object j : le) {
			String id =j.toString();
			
			Pattern pEmail = Pattern.compile("[a-zA-Z][a-zA-Z0-9_.]*@[a-zA-Z0-9].[a-zA-Z]");
			Matcher mEmail = pEmail.matcher(id);
			softy.assertTrue(mEmail.find(), id+" is not the valid Email ID");
		}
	softy.assertAll();
				
		
	}
	

	

}
