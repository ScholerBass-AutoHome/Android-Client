package com.autohome.autohomeclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class RoomActivity extends ActionBarActivity implements MaterialTabListener {

	String roomName;
	Toolbar toolbar;
	MaterialTabHost tabHost;
	ViewPager pager;
	ViewPagerAdapter adapter;
	Fragment[] fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			roomName = extras.getString(Shared.ROOM_NAME_INTENT_EXTRA_NAME);
		}



		toolbar = (Toolbar) findViewById(R.id.toolbar);

		tabHost = (MaterialTabHost) this.findViewById(R.id.room_tabHost);
		pager = (ViewPager) this.findViewById(R.id.room_pager);

		// init view pager
		adapter = new ViewPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// when user do a swipe the selected tab change
				tabHost.setSelectedNavigationItem(position);

			}
		});

		// insert all tabs from pagerAdapter data
		for (int i = 0; i < adapter.getCount(); i++) {
			tabHost.addTab(
					tabHost.newTab()
							.setText(adapter.getPageTitle(i))
							.setTabListener(this)
			);

		}

		toolbar.setTitle(roomName);

		fragments = new Fragment[adapter.getCount()];
		fragments[0] = new ApplianceListing();
		fragments[1] = new ScheduleListing();
		fragments[2] = new UnitListing();
	}


	@Override
	public void onTabSelected(MaterialTab tab) {
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabReselected(MaterialTab tab) {

	}

	@Override
	public void onTabUnselected(MaterialTab tab) {

	}

	private class ViewPagerAdapter extends FragmentStatePagerAdapter {

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);

		}

		public android.support.v4.app.Fragment getItem(int num) {
			return fragments[num];
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case 0:
					return "Appliances";
				case 1:
					return "Schedule";
				case 2:
					return "Units";
				default:
					return "";
			}
		}

	}
}
