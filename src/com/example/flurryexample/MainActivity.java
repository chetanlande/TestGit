package com.example.flurryexample;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.flurry.android.FlurryAgent;

public class MainActivity extends Activity implements OnClickListener {

	// String API_KEY = "YF6YCK2H8TJSQJTXDPTG";
	String API_KEY = "BNYP9X4627GJYYX63ZRK";
	Button art1;
	Button art2;
	Button art3;

	Map<String, String> articleParams = new HashMap<String, String>();
	Map<String, String> article = new HashMap<String, String>();

	@Override
	protected void onStart() {
		super.onStart();
		FlurryAgent.onStartSession(this, API_KEY);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
		
		
	}

	private void init() {
		initViews();
		initMembers();
		initData();
		initListeners();
		
	}

	private void initViews() {
		art1 = (Button) findViewById(R.id.button1);
		art2 = (Button) findViewById(R.id.button2);
		art3 = (Button) findViewById(R.id.button3);

	}

	private void initMembers() {
		
	}

	private void initData() {
		
	}

	private void initListeners() {
		art1.setOnClickListener(this);
		art2.setOnClickListener(this);
		art3.setOnClickListener(this);

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();

		FlurryAgent.onEndSession(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// Capture author info & user status

			articleParams.put("Author", "Chetan");
			articleParams.put("User_Status", "Registered");

			// Log the timed event when the user starts reading the article
			// setting the third param to true creates a timed event
			FlurryAgent.logEvent("Article_Read", articleParams, true);

			// End the timed event, when the user navigates away from article
			FlurryAgent.endTimedEvent("Article_Read");
			FlurryAgent.setUserId("11");
			FlurryAgent.setAge(21);
			FlurryAgent.setGender(com.flurry.android.Constants.MALE);
			
			float latitude = (float)21.1500;
			float longitude = (float)79.0900;
			FlurryAgent.setLocation(latitude, longitude);

			FlurryAgent.setReportLocation(true);
			FlurryAgent.onPageView();


			break;
		case R.id.button2:

			article.put("Author", "Ujwal");
			article.put("User_Status", "Registered");
			

			FlurryAgent.logEvent("Article_write", article, true);
			

			FlurryAgent.endTimedEvent("Article_write");
			
			FlurryAgent.setUserId("20");
			FlurryAgent.setAge(22);
			FlurryAgent.setGender(com.flurry.android.Constants.MALE);
			

			FlurryAgent.setReportLocation(true);

			break;
		case R.id.button3:

			break;
		default:
			break;
		}
	}

}
