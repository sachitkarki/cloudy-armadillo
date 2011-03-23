package com.monkelabs.cloudyarmadillo;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;
import android.content.*;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // register the intent listener
        
        RegisterIntent();
        
    }
    
    private void RegisterIntent()
    {
    	Intent regIntent = new Intent(getString(R.string.com_google_android_c2dm_intent_REGISTER));
    	
    	regIntent.putExtra("app", 
    			PendingIntent.getBroadcast(this, 0, new Intent(), 0));
    	
    	regIntent.putExtra("sender", getString(R.string.c2dm_sender_email));
    	
    	startService(regIntent);
    	    	
    }
    
    
    
    
}