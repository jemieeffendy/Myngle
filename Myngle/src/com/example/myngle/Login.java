package com.example.myngle;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends ActionBarActivity {

	private String loginUser;
	private String password;
	private String note = "none";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			return rootView;
		}
	}
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	public void submitButtonClicked(View view)
	{
		loginUser = ((EditText)findViewById(R.id.loginField)).getText().toString();
		password = ((EditText)findViewById(R.id.passwordField)).getText().toString();
		
		int login = 0;
		
		AlertDialog ad = new AlertDialog.Builder(this).create();  
		ad.setCancelable(true); // This blocks the 'BACK' button  
	
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
		StrictMode.setThreadPolicy(policy);
		
		try
		{
			login = 0;
			
			JSONObject json = DatabaseHandler.getJSONfromURL("http://www.exaclarion2317.com/Myngle/Myngle/login.php?username="+loginUser+"&password="+password);
			JSONArray jsonArr = json.getJSONArray("counter");
			
			json = jsonArr.getJSONObject(0);
			
			if (json != null) {
				if (loginUser.compareTo(json.getString("username")) == 0) {
					if (password.compareTo(json.getString("password")) == 0) {
						login = 1;
					}
				}
			}
			

			Log.e("Debug", json.getString("username"));
			
			if (login == 1) {
				note = "Login success!";
			}
			else {
				note = "Invalid username and password!";
			}
		}
		catch (Exception e)
		{
			//note = e.getMessage();
		}
		
		
		TextView text = (TextView) findViewById(R.id.statusView);
		text.setText(note);
	}
		
		
}
