package com.example.museapp;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.plus.PlusClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;



public class LoginWithGoogleActivity extends Activity implements
ConnectionCallbacks, OnConnectionFailedListener {


	private static final String TAG = "LoginWithGoogleActivity";
	private static final int REQUEST_CODE_RESOLVE_ERR = 9000;
	private ProgressDialog mConnectionProgressDialog;
	private PlusClient mPlusClient;
	private com.google.android.gms.common.ConnectionResult mConnectionResult;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_google_layout);



		mPlusClient = new PlusClient.Builder(this, this, this)
		.setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity")
		.setScopes(Scopes.PLUS_LOGIN)  // recommended login scope for social features
		// .setScopes("profile")       // alternative basic login scope
		.build();
		// Progress bar to be displayed if the connection failure is not resolved.
		mConnectionProgressDialog = new ProgressDialog(this);
		mConnectionProgressDialog.setMessage("Signing in...");

	}
	@Override
    protected void onStart() {
        super.onStart();
        mPlusClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlusClient.disconnect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
      if (mConnectionProgressDialog.isShowing()) {
        // The user clicked the sign-in button already. Start to resolve
        // connection errors. Wait until onConnected() to dismiss the
        // connection dialog.
        if (result.hasResolution()) {
          try {
                   result.startResolutionForResult(this, REQUEST_CODE_RESOLVE_ERR);
           } catch (SendIntentException e) {
                   mPlusClient.connect();
           }
        }
      }
      // Save the result and resolve the connection failure upon a user click.
      mConnectionResult = result;
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        if (requestCode == REQUEST_CODE_RESOLVE_ERR && responseCode == RESULT_OK) {
            mConnectionResult = null;
            mPlusClient.connect();
        }
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        String accountName = mPlusClient.getAccountName();
        Toast.makeText(this, accountName + " is connected.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDisconnected() {
        Log.d(TAG, "disconnected");
    }

}
