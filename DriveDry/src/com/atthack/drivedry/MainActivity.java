package com.atthack.drivedry;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("start", "Launching");
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
