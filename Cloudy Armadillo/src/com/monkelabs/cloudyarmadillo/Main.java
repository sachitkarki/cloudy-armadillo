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
        
        
        
        
    }
    
    private void RegisterIntent()
    {
    	Intent regIntent = new Intent(getString(R.string.c2dm_google_register_path));
    	
    	regIntent.putExtra("app", 
    			PendingIntent.getBroadcast(this, 0, new Intent(), 0));
    	
    	
    			
    	
    }
}