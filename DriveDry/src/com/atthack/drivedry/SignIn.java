package com.atthack.drivedry;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends Activity {
	
	Button SigninBtn;
	EditText usernamefield;
	EditText emailfield;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        Log.e("signin", "Launching");

        SigninBtn =(Button) findViewById(R.id.button1);
        SigninBtn.setOnClickListener(signinclick);
        
        usernamefield = (EditText) findViewById(R.id.editText1);
        emailfield = (EditText) findViewById(R.id.editText2);
	}
	
	View.OnClickListener signinclick = new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub

			String usertext = usernamefield.getText().toString();
			String emailtext = emailfield.getText().toString();
			
		    String urlsstring = "http://www.driveaward.com/api/register;name=" + usertext + ";email=" + emailtext;
		    Log.e("signin",urlsstring);
		    String s = HttpFetch.Get(urlsstring);

		    Log.e("signin","Result is"+s);
		    GlobalSettings.Score = Integer.parseInt(HttpFetch.Get("http://www.driveawards.com/api/get;user_id=1;score").trim());
		    Log.e("score",String.valueOf(GlobalSettings.Score));
		    
		   
		}
	};
}
