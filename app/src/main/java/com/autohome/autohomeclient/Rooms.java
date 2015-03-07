package com.autohome.autohomeclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

import com.twotoasters.android.support.v7.widget.LinearLayoutManager;
import com.twotoasters.android.support.v7.widget.RecyclerView;
import com.twotoasters.android.support.v7.widget.RecyclerView.ItemAnimator;
import com.twotoasters.layoutmanager.GridLayoutManager;

import java.util.ArrayList;


public class Rooms extends Activity {

	private static final String KEY_NAMES = "names";
	private static final String KEY_ANIMATION_INDEX = "animationIndex";
	private static final String KEY_LAYOUT_GRID = "layoutManager";

	private ArrayList<Room> rooms = new ArrayList<>();
	private int mAnimationIndex = 0;

	private RoomAdapter mAdapter;
	private RecyclerView mRecyclerView;

	private String[] mAnimationArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rooms);

		rooms.add(new Room("Living Room"));
		rooms.add(new Room("Kitchen"));
		rooms.add(new Room("Bedroom"));

		mRecyclerView = (RecyclerView) findWidgetById(R.id.room_recycler_view);
		mRecyclerView.setAdapter(getAdapter());
	}

	private void setLayoutManager(boolean shouldBeGrid) {
		if (mRecyclerView != null) {
			mRecyclerView.getItemAnimator().endAnimations();
			if (shouldBeGrid) {
				mRecyclerView.setLayoutManager(new GridLayoutManager(Rooms.this));
			} else {
				mRecyclerView.setLayoutManager(new LinearLayoutManager(Rooms.this));
			}
			// The recycle pool has to be cleared after the layout manager is changed.
			mRecyclerView.getRecycledViewPool().clear();
		}
	}

	private void restoreState(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			rooms = (ArrayList<Room>) savedInstanceState.getSerializable(KEY_NAMES);
			mAnimationIndex = savedInstanceState.getInt(KEY_ANIMATION_INDEX);
			setLayoutManager(savedInstanceState.getBoolean(KEY_LAYOUT_GRID, false));
		} else {
			Toast.makeText(this, "Tap to remove", Toast.LENGTH_LONG).show();
			setLayoutManager(false);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putSerializable(KEY_NAMES, rooms);
		outState.putInt(KEY_ANIMATION_INDEX, mAnimationIndex);
		if (mRecyclerView != null) {
			outState.putBoolean(KEY_LAYOUT_GRID, mRecyclerView.getLayoutManager() instanceof GridLayoutManager);
		}

		super.onSaveInstanceState(outState);
	}

	public <T extends View> T findWidgetById(int resId) {
		return (T) findViewById(resId);
	}

	private RoomAdapter getAdapter() {
		if (mAdapter == null) {
			mAdapter = new RoomAdapter(rooms);
		}
		return mAdapter;
	}
}
