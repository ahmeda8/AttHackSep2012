package com.atthack.drivedry;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class HttpFetch {
	public static String Get(String url)
	{
		String Answer = "";
		Log.e("httpclient","fetching");
		try
		{
			HttpClient client = new DefaultHttpClient();
			HttpGet getReq = new HttpGet(url);
			//HttpUriRequest getReq = new HttpUriRequest(url);
			try
			{
				HttpResponse resp = client.execute(getReq);
				InputStream in = resp.getEntity().getContent();
				BufferedReader read = new BufferedReader(new InputStreamReader(in));
				StringBuilder str = new StringBuilder();
				String line ="";
				while((line = read.readLine()) != null){
	                str.append(line + "\n");
	            }
	            in.close();
	            Answer = str.toString();
			}
			catch(Exception e)
			{
				Log.e("httpclient","Get response failure");
			}
		}
		catch (Exception e)
		{
			Log.e("httpclient","Get failure");
		}
		
		return Answer;
	}
}
