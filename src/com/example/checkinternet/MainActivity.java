package com.example.checkinternet;



import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt=(Button) findViewById(R.id.btn1);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ConnectivityManager connMgr =
				        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				    NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
				    if (activeInfo != null && activeInfo.isConnected()) {
				        boolean wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
				        boolean mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
				        if(wifiConnected) {
				        	Toast.makeText(getApplicationContext(),"WIFI connected", Toast.LENGTH_SHORT).show();
				        } else if (mobileConnected){
				        	Toast.makeText(getApplicationContext(),"Mobile Connected", Toast.LENGTH_SHORT).show();
				        }
				    } else {
				    	Toast.makeText(getApplicationContext(),"Neither Mobile nor WIFi connected.", Toast.LENGTH_SHORT).show();
				    }
			}
	
		});
	}

}
