package com.example.myngle;

import java.util.Date;


public class User {
	
	//TODO: consider how this would be loaded from the database. Some details such as address and phone number are private, and we don't even want the database to allow access to these. It would be wise to communicate with a PHP page, ande download a user's public details. If a user chooses not to share their address and phone etc., how will these variables be treated within this class?
	//TODO: each phone will have separate classes for the current user and for other users. How will we treat these classes separately?
	
	//I have decided to make these variables public. This way, the app can access them freely.
	public String userName; //This was forgotten on the class diagram
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	public String profilePicture;
	public String[] favouriteMovies;
	public String[] favouriteFoods;
	public String[] favouritePlaces;
	public String[] activities;
	public Date dateOfBirth;
	public Address address;
	public String phoneNumber;
	
	public User(String userName, String firstName, String lastName, String email, String[] favouriteMovies, String[] favouriteFoods, String[] favouritePlaces, String[] activities, Date dateOfBirth, Address address, String phoneNumber){
		//This constructor doesn't check to see if any details have been left blank so as if the database refuses access to a user's private information, the class can still exist.  
		this.userName = userName;
		this.lastName = lastName;
		this.email = email;
		this.favouriteMovies = favouriteMovies;
		this.favouriteFoods = favouriteFoods;
		this.activities = activities;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		
	}
	
	//No need for getters and setters, as all variables are public.
	
	
	
	

}
