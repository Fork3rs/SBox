package com.sbox.hack4good;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.touchmenotapps.widget.radialmenu.progress.widget.RadialProgressWidget;
import com.touchmenotapps.widget.radialmenu.progress.widget.RadialProgressWidget.OnRadialViewValueChanged;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenu;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenuItem;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed;

public class ThemperatureActivity extends Activity {

	private RadialProgressWidget mView;

	private SemiCircularRadialMenu mMenu;
	private SemiCircularRadialMenuItem mCamera, mhistory, mTemperature, mNotification,mSetting,mLighting	;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperature);

		TextView room_name = (TextView) this.findViewById(R.id.room_t);
room_name.setText(this.getIntent().getExtras().getString("room_name"));
	
		mView = (RadialProgressWidget) findViewById(R.id.radial_view);
		mMenu = (SemiCircularRadialMenu) findViewById(R.id.radial_menu_t);
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
		
		
		mView.setSecondaryText("Temperature");
		mView.setOnRadialViewValueChanged(new OnRadialViewValueChanged() {
			
			public void onValueChanged(int value) {
				WindowManager.LayoutParams lp = ThemperatureActivity.this.getWindow().getAttributes();
				lp.screenBrightness = value / 100.0f;
			}
		});
		
		if((int) (this.getWindow().getAttributes().screenBrightness * 100) < 0)
			mView.setCurrentValue(12);
		else
			mView.setCurrentValue((int) (this.getWindow().getAttributes().screenBrightness * 100));
		mCamera.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(ThemperatureActivity.this, mCamera.getText(),
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent(ThemperatureActivity.this, CamActivity.class);
				 intent.putExtra("room_name", ThemperatureActivity.this.getIntent().getExtras().getString("room_name"));
	               startActivity(intent);
			}
		});

		mhistory.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(ThemperatureActivity.this, mhistory.getText(),
						Toast.LENGTH_LONG).show();
			}
		});

		mTemperature.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(ThemperatureActivity.this, mTemperature.getText(),
						Toast.LENGTH_LONG).show();
				 Intent intent = new Intent(ThemperatureActivity.this, ThemperatureActivity.class);
				 intent.putExtra("room_name", ThemperatureActivity.this.getIntent().getExtras().getString("room_name"));
	               startActivity(intent);
			}
		});

		mNotification.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(ThemperatureActivity.this, mNotification.getText(),
						Toast.LENGTH_LONG).show();
			}
		});

		mSetting.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(ThemperatureActivity.this, mSetting.getText(),
						Toast.LENGTH_LONG).show();
				
			}
		});
		mLighting.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {

			public void onMenuItemPressed() {
				Toast.makeText(ThemperatureActivity.this, mLighting.getText(),
						Toast.LENGTH_LONG).show();
				
				 Intent intent = new Intent(ThemperatureActivity.this, LightingActivity.class);
				 intent.putExtra("room_name", ThemperatureActivity.this.getIntent().getExtras().getString("room_name"));
	               startActivity(intent);
				
			}
		});
		
	}
}
