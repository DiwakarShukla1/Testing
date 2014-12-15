package org.devgirl.test;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

public class Test extends CordovaPlugin {
	public static final String START = "start"; 
	

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		 
		try{
			Toast.makeText(this.cordova.getActivity(), "Background location tracking stopped", Toast.LENGTH_SHORT).show();
	 	 	callbackContext.success();
	 	 	return true;
		}catch(Exception e){
			return false;
		}
	}
}