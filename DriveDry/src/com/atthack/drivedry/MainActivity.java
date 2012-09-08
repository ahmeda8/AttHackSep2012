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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.*;


public class MainActivity extends Activity {

	//SmsReceiver ls = new SmsReceiver();
	ContentResolver cr;
	ImageButton Scout;
	ImageButton SettingBtn;
	ImageView mainb;
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
        
        
        //Display display = getWindowManager().getDefaultDisplay();
        //Log.e("display","h:"+display.getHeight()+"w"+display.getWidth());
        //mainb = (ImageView)findViewById(R.id.imageView1);
        //Log.e("display",mainb.get+"X"+mainb.getWidth());
        new Thread()
        {
        	@Override
        	public void run()
        	{
        		//Log.e("MainThread",HttpFetch.Get("http://www.google.com"));;
        		
        	}
        }.start();
        
        new Thread()
        {
        	@Override
        	public void run()
        	{
        		int n = 0;
        		while(n<60)
        		{
	        		GlobalSettings.Score += 100*GlobalSettings.Multiplier;
	        		//Log.e("main","score:"+GlobalSettings.Score + " Multiplier "+GlobalSettings.Multiplier);
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
        UpdateOdometer();
        //
        //IntentFilter ift = IntentFilter.create(action, dataType) 
        //Context.registerReceiver(ls, null);
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
//		int score = GlobalSettings.Score;
//		int a = score / 100000;
//		score = score % 100000;
//		int b = score / 10000;
//		score = score % 10000;
//		int c = score / 1000;
//		score = score % 1000;
//		int d = score / 100;
//		score = score % 100;
//		int e = score / 10;
//		score = score % 10;
//		
//		ImageView a1 = (ImageView)findViewById(R.id.imageView2);
//		ImageView a2 = (ImageView)findViewById(R.id.imageView3);
//		ImageView a3 = (ImageView)findViewById(R.id.imageView4);
//		ImageView a4 = (ImageView)findViewById(R.id.imageView5);
//		ImageView a5 = (ImageView)findViewById(R.id.imageView6);
//		ImageView a6 = (ImageView)findViewById(R.id.imageView7);
//		
//		Log.e("disp",String.valueOf(R.drawable.b1));
//		a1.setBackgroundResource(R.drawable.b1);
		
	}

    
}
