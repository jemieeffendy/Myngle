package com.example.myngle;

public class Address {
	
	private String street1;
	private String street2;
	private String postCode;//It is wise not to have this as an integer as stated in the class diatram. If Myngle is to spread to other countries, this needs to be a string. E.g. when I lived in England, my postcode was HD80QT. Also, because we won't be doing maths with the postcode, there is no need for the integer type, and if a postcode began with a 0, this would be removed by the integer datatype.
	private String state;
	private String city;
	private String country;
	
	//TODO: figure out how this would be saved to the database. Would we have a datatype for address, and include this in a column on the user table or would we have separate strings in the user table i.e. one string for address1, one for address 2 etc.
	
	public Address(String street1, String street2, String postCode, String city, String country){
	
		this.street1 = street1;
		this.street2 = street1;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
		
	}
	
	//As it is unlikely that only one part of someone's address would change, I see no need for setters. Instead, it is probably more efficient to just construct a new instance of the address class if someone changes address.
	
	public String getStreet1(){
		return street1;
	}
	
	public String getStreet2(){
		return street2;
	}
	
	public String getPostCode(){
		return postCode;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getCountry(){
		return country;
	}
	
	public String toStringDb() {
		String toStr = "";
		toStr = street1+","+street2+","+city+","+postCode+","+state+","+country;
		return toStr;
	}
}
