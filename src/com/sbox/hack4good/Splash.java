package com.sbox.hack4good;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;


public class Splash extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 2000;

    @Override
    public void onCreate(Bundle icicle) {
    	overridePendingTransition(R.anim.zoom_alpha_dialog, R.anim.zoom_alpha_dialog);
        super.onCreate(icicle);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable(){
        	
            public void run() {
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
    @Override
    protected void onResume() {

            setContentView(R.layout.splash);
        super.onResume();
    }
}