package com.test.Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import com.test.rest.Constants;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Util {

	public static RequestSpecification request_Spec;
	
	public static RequestSpecification request_Spec_Builder(String BaseURL) throws FileNotFoundException{
		PrintStream ps = new PrintStream(new FileOutputStream("logging.txt"));
		
		RestAssured.baseURI = (BaseURL==null)?Constants.BaseURL:BaseURL;
		HashMap<String, String> addparam = Constants.getParam();
		addparam.put("place_id", "a0ebd6830f1058ba5140f38cbe44469b");
		request_Spec = new RequestSpecBuilder().setBaseUri(RestAssured.baseURI).addQueryParams(addparam).
				addFilter(RequestLoggingFilter.logRequestTo(ps)).addFilter(ResponseLoggingFilter.logResponseTo(ps)).build();
		return request_Spec;
		
	}
}
