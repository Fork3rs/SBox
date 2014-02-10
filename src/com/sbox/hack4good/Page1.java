package com.sbox.hack4good;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Page1 extends android.support.v4.app.Fragment {
	View view;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
	  
     view = inflater.inflate(R.layout.page1,
        container, false);
    
    ImageView img = (ImageView) view.findViewById(R.id.marker);
    img.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
        	Intent intent = new Intent(view.getContext(), HouseActivity.class);
            startActivity(intent);

        }
    });
    return view;
  }
  
}