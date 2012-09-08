package com.atthack.drivedry;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.content.*;


public class MainActivity extends Activity {

	//SmsReceiver ls = new SmsReceiver();
	ContentResolver cr;
	ImageButton Scout;
	ImageButton SettingBtn;
	ImageView mainb;
	TextView odo;
	TextView multip;
	ToggleButton tb ;
	ImageButton ProfileBtn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("mainview", "Launching");
        cr =  this.getContentResolver();
        SmsObserver smo = new SmsObserver(new Handler());
        cr.registerContentObserver(Uri.parse("content://sms"), true, smo);
        Scout = (ImageButton) findViewById(R.id.imageButton2);
        Scout.setOnClickListener(listner);
        
        SettingBtn =(ImageButton) findViewById(R.id.imageButton3);
        SettingBtn.setOnClickListener(settingclick);
        
        odo = (TextView)findViewById(R.id.textView2);
		multip = (TextView)findViewById(R.id.textView3);
		
        tb = (ToggleButton)findViewById(R.id.toggleButton1);
        
        UpdateOdometer();
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				
			GlobalSettings.Run = isChecked;
			UpdateOdometer();
    		
			if(isChecked)
			{
				new Thread()
		        {
		        	@Override
		        	public void run()
		        	{
		        		int n = 0;
		        		while(n<60 && GlobalSettings.Run)
		        		{
			        		GlobalSettings.Score += 100*GlobalSettings.Multiplier;
			        		Log.e("main","score:"+GlobalSettings.Score + " Multiplier "+GlobalSettings.Multiplier);
			        		try
			        		{
			        			Thread.sleep(1000);
			        		}
			        		catch(Exception e)
			        		{
			        			Log.e("main exception",e.getMessage());
			        			break;
			        		}
			        		n++;
		        		}
		        	}
		        }.start();
			}
			}
		});
        //Display display = getWindowManager().getDefaultDisplay();
        //Log.e("display","h:"+display.getHeight()+"w"+display.getWidth());
        //mainb = (ImageView)findViewById(R.id.imageView1);
        //Log.e("display",mainb.get+"X"+mainb.getWidth());
        ProfileBtn = (ImageButton) findViewById(R.id.imageButton1);
        ProfileBtn.setOnClickListener(profileclick);
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    View.OnClickListener listner = new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getBaseContext(),TelenavActivity.class);
			i.putExtra("url", "http://www.google.com");
			startActivity(i);
			
		}
	};
	
	View.OnClickListener settingclick = new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getBaseContext(),Settings.class);
			startActivity(i);
			
		}
	};
	
	private void UpdateOdometer()
	{
		odo.setText(String.valueOf(GlobalSettings.Score));
		multip.setText(" x"+String.valueOf(GlobalSettings.Multiplier));
	}

	View.OnClickListener profileclick = new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getBaseContext(),Profile.class);
			startActivity(i);
			
		}
	};

}
