package com.atthack.drivedry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class Profile extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Log.e("profile", "Launching");

//        later on this will check whether or not a user is logged in. For now, assume not.
        boolean isLoggedIn = false;
        if (!isLoggedIn) {
        	Intent i = new Intent(getBaseContext(),SignIn.class);
			startActivity(i);
        }
        
	}
}
