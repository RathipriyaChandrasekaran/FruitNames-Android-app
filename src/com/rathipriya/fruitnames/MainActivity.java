package com.rathipriya.fruitnames;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

	
	protected int _splashTime=4000;
	MediaPlayer mp        = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//action bar color
		android.app.ActionBar bar=getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5C5C3D")));
		managerOfSound();
		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity
				Intent i = new Intent(MainActivity.this, FruitNameActivity.class);
				startActivity(i);

				// close this activity
				finish();
			}
		}, _splashTime);
	}

	private void managerOfSound() {
		if (mp != null) {
			mp.reset();
			mp.release();
		}
		mp = MediaPlayer.create(this, R.raw.fruits);

		mp.start();
	}


}
