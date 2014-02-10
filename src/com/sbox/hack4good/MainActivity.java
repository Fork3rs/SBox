package com.sbox.hack4good;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.ladhari.menu.Splinky_menu_Activity;


public class MainActivity extends Splinky_menu_Activity {

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		}
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;

			switch (position) {
			
			case 0:
				fragment = new Page1();
				break;
			case 1:
				fragment = new Page2();
				break;
			case 2:
				fragment = new Page3();
				break;
			case 3:
				fragment = new Page4();
				break;
			default:
				break;
			}

			
			return fragment;
		}

		@Override
		public int getCount() {
			
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section0).toUpperCase(l);
			case 1:
				return getString(R.string.title_section1).toUpperCase(l);
			case 2:
				return getString(R.string.title_section2).toUpperCase(l);
			case 3:
				return getString(R.string.title_section3).toUpperCase(l);

			
			}
			return null;
		}
	}



}
