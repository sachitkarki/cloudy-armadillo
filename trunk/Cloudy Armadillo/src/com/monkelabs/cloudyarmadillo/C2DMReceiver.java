package com.monkelabs.cloudyarmadillo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.content.SharedPreferences.Editor;




public class C2DMReceiver extends BroadcastReceiver {

	private Context context;
	
	private static String KEY;
	private static String REGISTRATION_KEY;

	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		this.context = context;
		
		KEY = this.context.getString(R.string.pref_reg_key_name);
		REGISTRATION_KEY = this.context.getString(R.string.pref_reg_key_value);
		
		
		if (intent.getAction().equals(this.context.getString(R.string.com_google_android_c2dm_intent_REGISTER))) {
	        handleRegistration(context, intent);
	    } else if (intent.getAction().equals(this.context.getString(R.string.com_google_android_c2dm_intent_RECEIVE))) {
	        handleMessage(context, intent);
	    }

		
	}
	
	private void handleRegistration(Context context, Intent intent) {
	    String registration = intent.getStringExtra(context.getString(R.string.registration_id));
	    if (intent.getStringExtra(context.getString(R.string.error)) != null) {
	        // Registration failed, should try again later.
		    Log.d("c2dm", context.getString(R.string.registration_failed));
		    String error = intent.getStringExtra(context.getString(R.string.error));
		    if(error == context.getString(R.string.service_not_avaliable)){
		    	Log.d("c2dm", context.getString(R.string.service_not_avaliable));
		    }else if(error == context.getString(R.string.account_missing)){
		    	Log.d("c2dm", context.getString(R.string.account_missing));
		    }else if(error == context.getString(R.string.authentication_failed)){
		    	Log.d("c2dm", context.getString(R.string.authentication_failed));
		    }else if(error == context.getString(R.string.too_many_registration)){
		    	Log.d("c2dm", context.getString(R.string.too_many_registration));
		    }else if(error == context.getString(R.string.invalid_sender)){
		    	Log.d("c2dm", context.getString(R.string.invalid_sender));
		    }else if(error == context.getString(R.string.phone_registration_error)){
		    	Log.d("c2dm", context.getString(R.string.phone_registration_error));
		    }
	    } else if (intent.getStringExtra(context.getString(R.string.unregistered)) != null) {
	        // unregistration done, new messages from the authorized sender will be rejected
	    	Log.d("c2dm", context.getString(R.string.unregistered));

	    } else if (registration != null) {
	    	Log.d("c2dm", registration);
	    	Editor editor =
                context.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
            editor.putString(REGISTRATION_KEY, registration);
    		editor.commit();
	       // Send the registration ID to the 3rd party site that is sending the messages.
	       // This should be done in a separate thread.
	       // When done, remember that all registration is done.
	    }
	}

	private void handleMessage(Context context, Intent intent)
	{
		//Do whatever you want with the message
	}

	
	
}
