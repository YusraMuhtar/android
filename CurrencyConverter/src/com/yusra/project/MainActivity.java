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
		final EditText tlField  = (EditText)findViewById(R.id.amountField);
		final EditText dollarField = (EditText)findViewById(R.id.dollarField);
		final EditText euroField = (EditText)findViewById(R.id.euroField);
		final EditText goldField = (EditText)findViewById(R.id.goldField);
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
					Double lira = rates.getDouble("TRY");
					Double euro = rates.getDouble("EUR");
					Double gold = rates.getDouble("XAU");
					Double dollar = 1 / lira;
					
					Double amount= Double.valueOf(tlField.getText().toString());
					
					dollarField.setText(String.valueOf(dollar*amount));
					euroField.setText(String.valueOf(euro*amount));
					goldField.setText(String.valueOf(gold*amount));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   
		    }

			
				
			

			
		    });
	}

	

}
