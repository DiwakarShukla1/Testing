package com.example.dkplugin;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

public class Test extends CordovaPlugin {
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		 public static final String START = "start"; 
		try{
			Toast.makeText(this.cordova.getActivity(), "Background location tracking stopped", Toast.LENGTH_SHORT).show();
	 	 	callbackContext.success();
	 	 	return true;
		}catch(Exception e){
			return false;
		}
	}
}