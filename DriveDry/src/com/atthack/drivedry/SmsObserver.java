package com.atthack.drivedry;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

public class SmsObserver extends ContentObserver{

	public static int messageReceived = 0;
	public static int messageSent = 0;
	
	public SmsObserver(Handler handler) {
		super(handler);
		Log.e("observer","created");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onChange(boolean selfChange) {
		super.onChange(selfChange);
		SmsObserver.messageSent += 1;
		if(SmsObserver.messageSent > SmsObserver.messageReceived*2) {
			SmsObserver.messageReceived = 0;
			SmsObserver.messageSent = 0;
			Log.e("observer","sms sent by user"+SmsObserver.messageReceived +" "+SmsObserver.messageSent);
			if(GlobalSettings.AutoRespond)
				GlobalSettings.Multiplier = 1;
		}
		else
			Log.e("observer","Auto sent sms"+SmsObserver.messageReceived +" "+SmsObserver.messageSent);
		//Uri smsuri = Uri.parse("content://sms");
		//Cursor cur = 
		
	}

}
