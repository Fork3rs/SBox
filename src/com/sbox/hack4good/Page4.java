package com.sbox.hack4good;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class Page4 extends android.support.v4.app.Fragment {
	View view;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
     view = inflater.inflate(R.layout.page4,
        container, false);
    
    ImageView img = (ImageView) view.findViewById(R.id.imageView4);
    img.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
			Toast.makeText(view.getContext(), "Stay tuned for the full version of SBox", Toast.LENGTH_LONG).show();


        }
    });
    return view;
  }
  
}