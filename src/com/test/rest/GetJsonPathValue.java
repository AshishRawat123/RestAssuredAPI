package com.test.rest;

import io.restassured.path.json.JsonPath;

public class GetJsonPathValue {

	public static String getValue_From_Response(String key, String response) {
		System.out.println("RESPONSE BODY  \n------------------------------"+response+"\n--------------------------------------------------");
		JsonPath jpath = new JsonPath(response);
		return jpath.getString(key);
	}
	
}
