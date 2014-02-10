package com.sbox.hack4good;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Web extends android.support.v4.app.Fragment {


	private WebView mWebView;
	
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.web,
        container, false);
    
    mWebView = (WebView) view.findViewById(R.id.activity_main_webview);
    WebSettings webSettings = mWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    mWebView.loadUrl("file:///android_asset/www/home/index.html");
    return view;
  }

}