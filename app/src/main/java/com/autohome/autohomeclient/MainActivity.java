package com.autohome.autohomeclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;

import com.software.shell.fab.ActionButton;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class MainActivity extends ActionBarActivity implements MaterialTabListener {

	String roomName;
	MaterialTabHost tabHost;
	ViewPager pager;
	ViewPagerAdapter adapter;
	ActionButton actionButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room);

		actionButton = (ActionButton) findViewById(R.id.fab);
		actionButton.setButtonColor(getResources().getColor(R.color.fab_material_pink_500));
		actionButton.setButtonColorPressed(getResources().getColor(R.color.fab_material_pink_900));
		actionButton.setImageDrawable(getResources().getDrawable(R.drawable.fab_plus_icon));
		actionButton.setShowAnimation(ActionButton.Animations.SCALE_UP);
		actionButton.setHideAnimation(ActionButton.Animations.SCALE_DOWN);
		actionButton.show();

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			roomName = extras.getString(Shared.ROOM_NAME_INTENT_EXTRA_NAME);
		}

		tabHost = (MaterialTabHost) this.findViewById(R.id.room_tabHost);
		pager = (ViewPager) this.findViewById(R.id.room_pager);

		// init view pager
		adapter = new ViewPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// when user do a swipe the selected tab change
				actionButton.hide();
				tabHost.setSelectedNavigationItem(position);
				actionButton.show();
			}
		});
		pager.setOffscreenPageLimit(adapter.getCount() - 1);

		// insert all tabs from pagerAdapter data
		for (int i = 0; i < adapter.getCount(); i++) {
			tabHost.addTab(
					tabHost.newTab()
							.setText(adapter.getPageTitle(i))
							.setTabListener(this)
			);

		}
	}


	@Override
	public void onTabSelected(MaterialTab tab) {
		pager.setCurrentItem(tab.getPosition());
		actionButton.show();
	}

	@Override
	public void onTabReselected(MaterialTab tab) {
		actionButton.show();
	}

	@Override
	public void onTabUnselected(MaterialTab tab) {}

	public void hideFAB() {
		Animation anim = actionButton.getHideAnimation();
		actionButton.setHideAnimation(ActionButton.Animations.JUMP_TO_DOWN);
		actionButton.hide();
		actionButton.setHideAnimation(anim);
	}

	public void showFAB() {
		Animation anim = actionButton.getShowAnimation();
		actionButton.setShowAnimation(ActionButton.Animations.JUMP_FROM_DOWN);
		actionButton.show();
		actionButton.setShowAnimation(anim);
	}

	private class ViewPagerAdapter extends FragmentStatePagerAdapter {

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);

		}

		public android.support.v4.app.Fragment getItem(int num) {
			switch (num) {
				case 0:
					return new ApplianceListing();
				case 1:
					return new ScheduleListing();
				case 2:
					return new UnitListing();
			}
			return new ApplianceListing();
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
