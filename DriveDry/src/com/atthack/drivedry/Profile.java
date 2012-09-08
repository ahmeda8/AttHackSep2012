package com.atthack.drivedry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Profile extends Activity {
	TextView pointsfield;
	TextView userfield;
	Button SignOutBtn;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Log.e("profile", "Launching");
        
        pointsfield = (TextView) findViewById(R.id.TextView02);
        pointsfield.setText("" + GlobalSettings.Score);
        
        userfield = (TextView) findViewById(R.id.textView1);
        userfield.setText("" + GlobalSettings.username);
        
        SignOutBtn =(Button) findViewById(R.id.button1);
        SignOutBtn.setOnClickListener(signoutclick);

//        later on this will check whether or not a user is logged in. For now, assume not.
        boolean isLoggedIn = false;
        if (GlobalSettings.username != "User") {
        		isLoggedIn = true;
        }
        if (!isLoggedIn) {
        	Intent i = new Intent(getBaseContext(),SignIn.class);
			startActivity(i);
        }
        
        userfield = (TextView) findViewById(R.id.textView1);
        userfield.setText("" + GlobalSettings.username);

        
	}
	
	View.OnClickListener signoutclick = new View.OnClickListener() {
		
		public void onClick(View v) {
			Intent i = new Intent(getBaseContext(),SignIn.class);
			startActivity(i);
		}
	};
}
