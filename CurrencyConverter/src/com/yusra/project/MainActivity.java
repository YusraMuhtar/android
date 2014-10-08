package com.yusra.project;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button)findViewById(R.id.convertButton);
		EditText tlField  = (EditText)findViewById(R.id.amountField);
		EditText dollarField = (EditText)findViewById(R.id.dollarField);
		EditText euroField = (EditText)findViewById(R.id.euroField);
		EditText goldField = (EditText)findViewById(R.id.goldField);
		String webSite = "http://openexchangerates.org/api/latest.json?app_id=81544ed74728442fa2218b0f32d41682";
		
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(webSite, new JsonHttpResponseHandler() {

		  

		    @Override
		    public void onSuccess(int statusCode, Header[] headers, String site) {
		        // called when response HTTP status is "200 OK"
		    	Log.i("lOGS", site);
		    	try {
					JSONObject result = new JSONObject(site);
					JSONObject rates = result.getJSONObject("rates"); 
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   
		    }

			
				
			

			
		    });
	}

	

}
