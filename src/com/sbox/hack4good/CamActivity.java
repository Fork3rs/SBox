package com.sbox.hack4good;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class CamActivity extends Activity {
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		
//		super.loadUrl("http://192.168.1.111:55555/videostream.cgi?user=admin&pwd=123456");
//
//		
//		
//	}
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
//	setContentView(R.layout.web);
	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.1.111:55555/videostream.cgi?user=admin&pwd=123456"));
	startActivity(browserIntent);
//    mWebView = (WebView) findViewById(R.id.activity_main_webview);
//    
//    mWebView.getSettings().setJavaScriptEnabled(true);     
//    mWebView.getSettings().setLoadWithOverviewMode(true);
//    mWebView.getSettings().setUseWideViewPort(true);     
//    mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
//    mWebView.loadUrl("file:///android_asset/www/cam.html");
    
	setContentView(R.layout.cam);
	VideoView video=(VideoView)findViewById(R.id.cam_view);
    
    String path1="http://192.168.1.111:55555/snapshot.cgi?user=admin&pwd=123456";

    Uri uri=Uri.parse(path1);
    video.setVideoURI(uri);
    video.start();
}
}
