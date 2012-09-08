package com.atthack.drivedry;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;

public class TelenavActivity extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telenav);
        Log.e("telenavview", "Launching");
        WebView myWebView = (WebView) findViewById(R.id.webView1);
        Bundle extras = getIntent().getExtras();
        myWebView.loadUrl(extras.getString("url"));
    }

}
