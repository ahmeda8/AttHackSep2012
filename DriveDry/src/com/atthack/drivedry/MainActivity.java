package com.atthack.drivedry;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.*;


public class MainActivity extends Activity {

	//SmsReceiver ls = new SmsReceiver();
	ContentResolver cr;
	Button Scout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("mainview", "Launching");
        cr =  this.getContentResolver();
        SmsObserver smo = new SmsObserver(new Handler());
        cr.registerContentObserver(Uri.parse("content://sms"), true, smo);
        Scout = (Button) findViewById(R.id.button1);
        Scout.setOnClickListener(listner);
        new Thread()
        {
        	@Override
        	public void run()
        	{
        		Log.e("MainThread",HttpFetch.Get("http://www.google.com"));;
        		
        	}
        }.start();
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

    public void testCommunication(int i) {
	for(int j = 0;j<=i;j++) {
	    Log.e("debug","this is a test message");
	}
    }

    
}
