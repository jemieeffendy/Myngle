package com.example.myngle;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Message {

	private User to;
	private User from;
	
	private String message;
	
	private Date dateOfMessage;
	
	public Message(User from, User to, String message){
		
		this.from = from;
		this.to = to;
		this.message = message;
		
		Calendar c = new GregorianCalendar(TimeZone.getTimeZone("Universal"));
		this.dateOfMessage = c.getTime();
		
	}
	
	public User getReceiver(){
		
		return to;
		
	}
	
	public User getSender(){
		
		return from;
		
	}
	
	public String getMessage(){
	
		return message;
		
	}
	
	public Date getDate(TimeZone zone){
		GregorianCalendar c = new GregorianCalendar(TimeZone.getTimeZone("Universal"));
		c.setTime(dateOfMessage);
		c.setTimeZone(zone);
		return c.getTime();
	}
	
	public Date getDate(){
		return getDate(TimeZone.getDefault());
	}
	
}
