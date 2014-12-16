package org.devgirl.test;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.net.Uri;
import android.widget.Toast;

public class Test extends CordovaPlugin {
	public static final String START = "start"; 
	Context context=null;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		context=this.cordova.getActivity().getApplicationContext();
		try{
			Toast.makeText(this.cordova.getActivity(), "Background location tracking stopped", Toast.LENGTH_SHORT).show();
			turnGPSOn();
	 	 	callbackContext.success();
	 	 	return true;
		}catch(Exception e){
			return false;
		}
	}

	public void turnGPSOn()
	{
	     Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
	     intent.putExtra("enabled", true);
	     context.sendBroadcast(intent);

	    String provider = Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
	    if(!provider.contains("gps")){ //if gps is disabled
	        final Intent poke = new Intent();
	        poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider"); 
	        poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
	        poke.setData(Uri.parse("3")); 
	        context.sendBroadcast(poke);
	    }
	}
}