package com.atthack.drivedry;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.content.*;


public class MainActivity extends Activity {

	//SmsReceiver ls = new SmsReceiver();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("mainview", "Launching");
        //IntentFilter ift = IntentFilter.create(action, dataType) 
        //Context.registerReceiver(ls, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void testCommunication(int i) {
	for(int j = 0;j<=i;j++) {
	    Log.e("debug","this is a test message");
	}
    }

    
}
