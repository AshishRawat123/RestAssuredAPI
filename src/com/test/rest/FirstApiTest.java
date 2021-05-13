package com.test.rest;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        String userName = "TOOLSQA-Test";
        String password = "Test@@123";
        String baseUrl = "https://bookstore.toolsqa.com";
        
        RestAssured.baseURI = baseUrl;
        RequestSpecification req = RestAssured.given();
        
        req.header("Content-type","application/json");
        
        //GET Token
        JSONObject requestParams = new JSONObject();
        
        
        Response response = req.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");
        String token =JsonPath.from(response.asString()).get("token");
        System.out.println(token);
        
        //GET BOOKS
        response = req.get("/BookStore/v1/Books");
        List<Map<String,String>> books=JsonPath.from(response.asString()).get("books"); 
        for(Map <String,String> str : books)
        System.out.println(str.get("title"));
        
        
	}

}
