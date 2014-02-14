package com.example.museapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class MuseMainActivity extends Activity  {
	
	ImageView muselogo,facebookImage,gmailImage;
	TextView tvSkip;

	//	628926040504948-app id


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		muselogo=(ImageView) findViewById(R.id.muse_image);
		facebookImage=(ImageView) findViewById(R.id.muse_image_facebook);
		gmailImage=(ImageView) findViewById(R.id.muse_image_gmail);

		tvSkip=(TextView) findViewById(R.id.tv_skip_continue);

		//code to signup by face book and gmail


		facebookImage.setOnClickListener(new  OnClickListener() {

			@Override
			public void onClick(View arg0) {


				Intent  intent=new Intent(getApplicationContext(),LoginViaFaceBookActivity.class);
				startActivity(intent);
			}
		});

		gmailImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(MuseMainActivity.this, "gmail SignUp",0).show();
				Intent intent=new Intent(getApplicationContext(),LoginWithGoogleActivity.class);
				startActivity(intent);
				
			}

			
		});

		tvSkip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),MainPageActivity.class);
				startActivity(intent);

			}
		});

	}

	
}
