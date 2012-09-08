package com.atthack.drivedry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SignIn extends Activity {
	
	Button SigninBtn;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        Log.e("signin", "Launching");

        SigninBtn =(Button) findViewById(R.id.button1);
        SigninBtn.setOnClickListener(signinclick);
	}
	
	View.OnClickListener signinclick = new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Log.e("signin","This is the signin click");
			
		}
	};
}
