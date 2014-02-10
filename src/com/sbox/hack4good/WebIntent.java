package com.sbox.hack4good;


import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

public class WebIntent extends CordovaPlugin  {

	
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		
		if (action.equals("startActivity")) {
			if (args.length() != 1) {
				return false;
			}
			JSONObject obj;
			try {
			obj = args.getJSONObject(0);
			String login = obj.has("login") ? obj.getString("login") : null;
			String password = obj.has("password") ? obj
					.getString("password") : null;
			if (login.equals("admin")&&password.equals("admin")){
				Intent intent = new Intent(this.webView.getContext(),MainActivity.class);
				this.webView.getContext().startActivity(intent);
			}else{
				return false;
			}
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}

	return true;
	} 

	
}
