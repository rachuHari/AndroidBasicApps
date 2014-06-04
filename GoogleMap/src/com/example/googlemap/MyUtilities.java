package com.example.googlemap;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class MyUtilities {

	public static void tost(Context context,String msg){
		Toast toast =Toast.makeText(context, msg, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}
