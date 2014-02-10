package com.sbox.hack4good;

import org.apache.cordova.DroidGap;

import android.os.Bundle;


public class Authentication extends DroidGap {
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	super.loadUrl("file:///android_asset/www/index.html");
}
}
