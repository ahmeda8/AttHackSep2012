package com.atthack.drivedry;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

public class Settings extends Activity {

	CheckBox autoRespond;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Log.e("setting", "Launching");
        autoRespond = (CheckBox)findViewById(R.id.checkBox1);
       	autoRespond.setChecked(GlobalSettings.AutoRespond);
       	autoRespond.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				
			GlobalSettings.AutoRespond = isChecked;	
			}
		}); 
	}
	
	
}
