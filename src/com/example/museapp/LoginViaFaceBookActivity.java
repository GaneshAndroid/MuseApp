package com.example.museapp;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;

public class LoginViaFaceBookActivity extends Activity {

	
	Session.StatusCallback statusCallback = new SessionStatusCallback();
	Session session;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_facebook_layout);
		
		session = Session.getActiveSession();
	    if (session == null) {
	        if (savedInstanceState != null) {
	            session = Session.restoreSession(this, null, statusCallback, savedInstanceState);
	        }
	        if (session == null) {
	            session = new Session(this);
	        }
	        Session.setActiveSession(session);
	        if (session.getState().equals(SessionState.CREATED_TOKEN_LOADED)) {
	            session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
	        }
	    }
		//facebookAuthentication();
		facebookAuthenticationSecond();
		
	}

	

	private void facebookAuthentication() {
		Session.openActiveSession(this, true, new Session.StatusCallback() {

			

			// callback when session changes state
			@SuppressWarnings("deprecation")
			@Override
			public void call(Session session, SessionState state, Exception exception) {
				if (session.isOpened()) {
					Log.d("facebook", "111before going to main page");
					// make request to the /me API
					Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

						// callback after Graph API response with user object
						@Override
						public void onCompleted(GraphUser user, Response response) {
							if (user != null) {
								Log.d("facebook", "before going to main page");
								/*TextView welcome = (TextView) findViewById(R.id.tv_facebook_login);
								welcome.setText("Hello " + user.getName() + "!");*/
								
								Log.d("facebook", "going to main page");
							}
						}
					});
				}
			}
		});

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

	private void facebookAuthenticationSecond() {
		Session session = Session.getActiveSession();
        if (!session.isOpened() && !session.isClosed()) {
            session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
        } else {


            Session.openActiveSession(this,true,new StatusCallback() {

                @Override
                public void call(final Session session, SessionState state, Exception exception) {
                    // TODO Auto-generated method stub
                    if (session.isOpened()) {
                        Request.executeMeRequestAsync(session,new Request.GraphUserCallback() {

                            @Override
                            public void onCompleted(GraphUser user,Response response) {
                                if (user != null) {

                                   String access_token = session.getAccessToken();
                                   String  firstName = user.getFirstName();
                                   String fb_user_id = user.getId();

                                   GraphObject graphObject = response.getGraphObject();
                                   JSONObject jsonObject = graphObject.getInnerJSONObject();

                                   try {
                                    String facebookEmail = jsonObject.getString("email");
                                    System.out.println("facebookEmail Login " + facebookEmail);
                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

//                                 System.out.println("json object -> "+jsonObject);
//                                  
                                    System.out.println("First Name Login:"+ firstName);
                                    System.out.println("FB USER ID Login: " + fb_user_id);

                                }
                            }
                        });
                        System.out.println("session is opened");
                    }else{
                        System.out.println("session is not opened");

                    }
                    System.out.println("Session state "+state);
                    if(exception!=null){
                        System.out.println("Exception in login "+exception.getMessage());
                    }
                }
            });
        }
    }
	private class SessionStatusCallback implements Session.StatusCallback {
	    @Override
	    public void call(Session session, SessionState state, Exception exception) {
	       // your code. will execute when you are already logged in
	    	Intent intent=new Intent(getApplicationContext(),MainPageActivity.class);
			startActivity(intent);
	    }
	}
		
	}



