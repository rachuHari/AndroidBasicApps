package com.example.jokes;


import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {

	Button btnNext;
	Button btnRandom;
	Button btnPrevious;
	
	TextView textJokes;
	
	List<String> jokes;
	ListIterator iterator;
	
	SharedPreferences preferences;
	private String prefName = "MyPrefJokes";
	private static final String TEXT_JOKES = "JOKES";
	
	static int currentindex;
	
	private SensorManager smanager;
	private float mAccel;
	private float mAccelCurrent;
	private float mAccelLast;
	private Sensor accel;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityjokes_main);
        btnNext=(Button) findViewById(R.id.btnNext);
        btnPrevious=(Button) findViewById(R.id.btnPrev);
        btnRandom=(Button) findViewById(R.id.btnRandom);
        
        smanager=(SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        accel=smanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mAccel=0.0f;
        mAccelCurrent=SensorManager.GRAVITY_EARTH;
        mAccelLast=SensorManager.GRAVITY_EARTH;
        
        textJokes=(TextView) findViewById(R.id.textJokes);
        jokes=Arrays.asList(getResources().getStringArray(R.array.JokesArray));
        iterator=jokes.listIterator();
        
       
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	smanager.registerListener(this, accel , SensorManager.SENSOR_DELAY_NORMAL);
    	restoreJokes();
    }
    
    protected void onStop() {
		super.onStop();
		smanager.unregisterListener(this, accel);
	}
    
    @Override
	protected void onPause() {
		super.onPause();
		preferences=getSharedPreferences(prefName, MODE_PRIVATE);
		SharedPreferences.Editor editor=preferences.edit();
		
		String jokesString=textJokes.getText().toString();
		editor.putString(TEXT_JOKES, jokesString);
		
		editor.commit();
		
		Toast toast=Toast.makeText(getBaseContext(), "Jokes saved successfully", Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM, 0, 0);
		toast.show();
	}
    
    
	private void restoreJokes() {

		SharedPreferences prefs = getSharedPreferences(prefName, MODE_PRIVATE);

		textJokes.setText(prefs.getString(TEXT_JOKES, ""));
		
		int current=currentindex;
		System.out.println("inside restore jokes "+current);
		
		//iterator.set(current);
		//System.out.println("restore jokes current "+iterator.next());

		btnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (iterator.hasNext()) {
					textJokes.setText(iterator.next().toString());
				} else {
					textJokes
							.setText("Dear user, you have reached the end.. MORE JOKES COMING SOON");
				}
			}
		});

		btnPrevious.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (iterator.hasPrevious()) {
					textJokes.setText(iterator.previous().toString());
				} else {
					textJokes
							.setText("Dear user, you are at the Beginning.. Select next to read more jokes");
				}
			}
		});
		btnRandom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Random random = new Random();
				int randmNumber = random.nextInt(5 - 1) + 1;
				textJokes.setText(jokes.get(randmNumber).toString());
			}
		});

	}

	public void goToJokes(View view) {
		switch (view.getId()) {
		case R.id.btnNext:
			if (iterator.hasNext()) {
				//currentindex=iterator.nextIndex();
				//System.out.println("Inside getJokes"+currentindex);
				
				textJokes.setText(iterator.next().toString());
				
			} else {
				currentindex=iterator.nextIndex();
				System.out.println("Inside getJokes"+currentindex);
				textJokes
						.setText("Dear user, you have reached the end.. MORE JOKES COMING SOON");
			}
			break;
		case R.id.btnPrev:
			if (iterator.hasPrevious()) {
				textJokes.setText(iterator.previous().toString());
			} else {
				textJokes
						.setText("Dear user, you are at the Beginning.. Select next to read more jokes");
			}
			break;
		case R.id.btnRandom:
			randomizedJokes();
			break;
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		float x=event.values[0];
		float y=event.values[1];
		float z=event.values[2];
		mAccelLast=mAccelCurrent;
		mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
		float delta=mAccelCurrent-mAccelLast;
		mAccel = mAccel * 0.9f + delta;
		
		if(mAccel>=2){
			Toast.makeText(getBaseContext(), "Device shaked!!", Toast.LENGTH_SHORT).show();
			randomizedJokes();
		}
	}

	private void randomizedJokes() {
		Random random = new Random();
		int randmNumber = random.nextInt(5 - 1) + 1;
		textJokes.setText(jokes.get(randmNumber).toString());
	}
	

	/*@Override
	public String toString() {
		
		String welcome=toString(textJokes.setText(""));
		return 
	}*/
    
    

}
