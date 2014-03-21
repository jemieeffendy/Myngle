package com.example.myngle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DatabaseHandler {
	
	public static JSONObject getJSONfromURL(String url) {
	    InputStream is = null;
	    String result = "";
	    JSONObject jArray = null;

	    // Download JSON data from URL
	    try {
	        HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost(url);
	        HttpResponse response = httpclient.execute(httppost);
	        HttpEntity entity = response.getEntity();
	        is = entity.getContent();

	    } catch (Exception e) {
	        Log.e("log_tag", "Error in http connection " + e.toString());
	    }

	    // Convert response to string
	    try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                is, "iso-8859-1"), 8);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	        is.close();
	        result = sb.toString();
	        Log.e("Result",result);
	    } catch (Exception e) {
	        Log.e("log_tag", "Error converting result " + e.toString());
	    }

	    try {
	    	String newResult = result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1);
	        jArray = new JSONObject(newResult);
	    } catch (JSONException e) {
	        Log.e("log_tag", "Error parsing data " + e.toString());
	    }

	    return jArray;
	}
	
	public static boolean addUser(User inUser) {
		
		boolean success = true;
		
		try {
			
			String url;
			String username = inUser.userName;
			String password = inUser.password;
			String firstname = inUser.firstName;
			String lastname = inUser.lastName;
			String profilePicture = inUser.profilePicture;
			String email = inUser.email;
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-mm-dd");
			String dateofbirth = sdt.format(sdt);
			String address = inUser.address.toStringDb();
			String phone = inUser.phoneNumber;
			
			url = "http://www.exaclarion2317.com/Myngle/Myngle/addUser.php?username="+username+
				  "&password="+password+"&firstname="+firstname+"&lastname="+lastname+"&profilepicture="+profilePicture
				  +"&email="+email+"&dateofbirth="+dateofbirth+"&address="+address+"&phone="+phone;
			
		    HttpClient httpclient = new DefaultHttpClient();
		    HttpResponse response = httpclient.execute(new HttpGet(url));
		  
		} catch (Exception e) {
		    Log.e("[GET REQUEST]", "Network exception", e);
		    success = false;
		 }
		return success;
		}

}
