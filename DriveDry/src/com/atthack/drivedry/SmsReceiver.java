package com.atthack.drivedry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		if(GlobalSettings.AutoRespond)
		{
			Bundle pudsBundle = arg1.getExtras();
			Object[] pdus = (Object[]) pudsBundle.get("pdus");
			SmsMessage messages = SmsMessage.createFromPdu((byte[])pdus[0]);
			String destinationAddress = messages.getOriginatingAddress();
			SmsManager sms = SmsManager.getDefault();
			String url = "http://www.driveawards.com/map.php?lat=34.020&lon=-118.489";
			String text = "Hi Honey I am driving right now. I am here : "+url;
			Log.e("sms", "message received");
			sms.sendTextMessage(destinationAddress, null, text, null, null);
			SmsObserver.messageReceived += 1;
			
		}
		GlobalSettings.Multiplier += 1;
		
	}
	
}