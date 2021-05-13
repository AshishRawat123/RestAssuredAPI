package com.test.rest;

import java.util.HashMap;

public class Constants {
	
	public static String BaseURL ="https://rahulshettyacademy.com";	
	public static String GetResource = "maps/api/place/get/json";
	public static String PostResource = "maps/api/place/add/json";
	public static String  PutResource = "maps/api/place/update/json";
	public static String DeleteResource = "/maps/api/place/delete/json";
	
	public static HashMap<String, String> getParam (){
		HashMap<String, String> param1= new HashMap<>();
		param1.put("key", "qaclick123");
		return param1;
	}
	
	public static HashMap<String, String> modifyHeader(){
		HashMap<String, String> content= new HashMap<>();
		content.put("Content-Type", "application/json");
		return content;
	}

}
