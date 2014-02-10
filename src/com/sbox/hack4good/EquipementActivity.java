package com.sbox.hack4good;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ladhari.adapters.EquipementItemAdapter;
import com.ladhari.menu.Splinky_menu_Activity;
import com.ladhari.objects.Equipement;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenu;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenuItem;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed;

public class EquipementActivity extends Splinky_menu_Activity {
	ArrayList<Equipement> Equipements = new ArrayList<Equipement>();
	private SemiCircularRadialMenu mMenu;
	private SemiCircularRadialMenuItem mCamera, mhistory, mTemperature, mNotification,mSetting,mLighting	;
	@Override
	public  void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room_equipement);

		Equipements.add(new Equipement("door", "on","od0"));
		Equipements.add(new Equipement("window", "off","od1"));
		Equipements.add(new Equipement("TV", "off","od2"));
		Equipements.add(new Equipement("PC", "off","od3"));
		Equipements.add(new Equipement("door", "on","od4"));
		Equipements.add(new Equipement("window", "off","od5"));
		Equipements.add(new Equipement("TV", "off","od6"));
		Equipements.add(new Equipement("PC", "off","od7"));

		TextView room_name = (TextView) this.findViewById(R.id.room_txt);
room_name.setText(this.getIntent().getExtras().getString("room_name"));

		ListView list = (ListView) this.findViewById(R.id.list_equipement);
		EquipementItemAdapter adpt = new EquipementItemAdapter(this,
				Equipements);

		list.setAdapter(adpt);
		ConnectivityManager conMgr = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo i = conMgr.getActiveNetworkInfo();
		  if (i == null||!i.isConnected()||!i.isAvailable())
		  {
			  new AlertDialog.Builder(this)
		        .setTitle("Connectivity error")
		        .setMessage("Please check your internet connection")
		        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) { 
		            	startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
		            }
		         })
		        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) { 
		                // do nothing
		            }
		         })
		        .setIcon(R.drawable.ic_action_warning)
		         .show();  
		  }
		  
		
		/***/
		
		/***/
		mMenu = (SemiCircularRadialMenu) findViewById(R.id.radial_menu);
		mMenu.setCloseMenuText("Close Menu");
		mMenu.setOpenMenuText("Open Menu");

		mCamera = new SemiCircularRadialMenuItem("camera", getResources().getDrawable(R.drawable.ic_action_camera), "Camera");
		mhistory = new SemiCircularRadialMenuItem("history", getResources().getDrawable(R.drawable.ic_action_view_as_list), "History");
		mTemperature = new SemiCircularRadialMenuItem("temperature", getResources().getDrawable(R.drawable.icon_temp), "Temperature");
		mNotification = new SemiCircularRadialMenuItem("notification", getResources().getDrawable(R.drawable.ic_action_alarms), "Notification");
		mSetting = new SemiCircularRadialMenuItem("setting", getResources().getDrawable(R.drawable.ich_action_settings), "Setting");
		mLighting = new SemiCircularRadialMenuItem("lighting", getResources().getDrawable(R.drawable.ic_action_brightness_high), "Lighting");

		mMenu.addMenuItem(mCamera.getMenuID(), mCamera);
		mMenu.addMenuItem(mhistory.getMenuID(), mhistory);
		mMenu.addMenuItem(mTemperature.getMenuID(), mTemperature);
		mMenu.addMenuItem(mNotification.getMenuID(), mNotification);
		mMenu.addMenuItem(mSetting.getMenuID(), mSetting);
		mMenu.addMenuItem(mLighting.getMenuID(), mLighting);

		mCamera.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(EquipementActivity.this, mCamera.getText(),
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent(EquipementActivity.this, CamActivity.class);
				 intent.putExtra("room_name", EquipementActivity.this.getIntent().getExtras().getString("room_name"));
	               startActivity(intent);
	               finish();
			}
		});

		mhistory.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(EquipementActivity.this, mhistory.getText(),
						Toast.LENGTH_LONG).show();
			}
		});

		mTemperature.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(EquipementActivity.this, mTemperature.getText(),
						Toast.LENGTH_LONG).show();
				 Intent intent = new Intent(EquipementActivity.this, ThemperatureActivity.class);
				 intent.putExtra("room_name", EquipementActivity.this.getIntent().getExtras().getString("room_name"));
	               startActivity(intent);
	               finish();
			}
		});

		mNotification.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(EquipementActivity.this, mNotification.getText(),
						Toast.LENGTH_LONG).show();
			}
		});

		mSetting.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(EquipementActivity.this, mSetting.getText(),
						Toast.LENGTH_LONG).show();
				
			}
		});
		mLighting.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(EquipementActivity.this, mLighting.getText(),
						Toast.LENGTH_LONG).show();
				
				 Intent intent = new Intent(EquipementActivity.this, LightingActivity.class);
				 intent.putExtra("room_name", EquipementActivity.this.getIntent().getExtras().getString("room_name"));
	               startActivity(intent);
	               finish();
				
			}
		});

	}



}

