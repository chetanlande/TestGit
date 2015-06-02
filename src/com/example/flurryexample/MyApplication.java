package com.example.flurryexample;

import com.flurry.android.FlurryAgent;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

	// String API_KEY = "YF6YCK2H8TJSQJTXDPTG";
	String API_KEY = "BNYP9X4627GJYYX63ZRK";

	@Override
	public void onCreate() {

		super.onCreate();

		// configure Flurry
		FlurryAgent.setLogEnabled(true);
		FlurryAgent.setLogLevel(Log.VERBOSE);

		
		FlurryAgent.init(this, API_KEY);
	}
}
