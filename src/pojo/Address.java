package pojo;

import java.util.HashMap;
import java.util.Map;

public class Address {

	
	private String suite;
	private String city;
	private String zipcode;
	private GetUserLocation geo;
	private String street;

	public String getStreet() {
	return street;
	}

	public void setStreet(String street) {
	this.street = street;
	}

	public String getSuite() {
	return suite;
	}

	public void setSuite(String suite) {
	this.suite = suite;
	}

	public String getCity() {
	return city;
	}

	public void setCity(String city) {
	this.city = city;
	}

	public String getZipcode() {
	return zipcode;
	}

	public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
	}

	public GetUserLocation getGeo() {
	return geo;
	}

	public void setGeo(GetUserLocation geo) {
	this.geo = geo;
	}
	
}
