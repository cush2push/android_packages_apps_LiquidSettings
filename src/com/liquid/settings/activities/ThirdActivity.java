
package com.liquid.settings.activities;

import com.liquid.settings.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.view.MotionEvent;

public class ThirdActivity extends Activity {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureDetector;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
 
        gestureDetector = new GestureDetector(new MyGestureDetector());
        View main_view_3 = (View) findViewById(R.id.mainView3);
 
        // Set the touch listener for the main view to be our custom gesture listener
        main_view_3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                }
                return false;
            }
        });
    }

    class MyGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
                return false;
            }

            // right to left swipe next Activity
            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Log.d("DEBUG-------", "left");
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
    		startActivity(intent);
    		ThirdActivity.this.overridePendingTransition(
			R.anim.slide_in_right,
			R.anim.slide_out_left
    		);
            finish();

    	    // left to right swipe previous Activity
            }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Log.d("DEBUG-------", "right");
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
    		startActivity(intent);
    		ThirdActivity.this.overridePendingTransition(
                    R.anim.slide_in_left, 
                    R.anim.slide_out_right
    	        );
            finish();
            }

            return false;
        }

        // It is necessary to return true from onDown for the onFling event to register
        @Override
        public boolean onDown(MotionEvent e) {
	    return true;
        }
    }
}