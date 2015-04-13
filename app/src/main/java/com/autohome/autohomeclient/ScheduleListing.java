package com.autohome.autohomeclient;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;


public class ScheduleListing extends Fragment {

	ListView listView;
	ArrayList<ScheduleInstance> scheduleInstances = new ArrayList<>();
	MainActivity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View V = inflater.inflate(R.layout.fragment_schedule_listing, container, false);
		Resources res = getResources();

		for (int i = 0; i < 10; i++) {
			scheduleInstances.add(new ScheduleInstance("Alarm " + i, new Date(2015, 4, 13, 13 + i, 5),
					new Date(2015, 4, 13, 14 + i, 0), new boolean[]{true, true, true, true, true, true, true},
					true, true, null));
		}

		listView = (ListView) V.findViewById(R.id.schedule_list);

		ScheduleAdapter adapter = new ScheduleAdapter(super.getActivity(), scheduleInstances, res);

		listView.setAdapter(adapter);
		final int prevFirstItemPosition = listView.getFirstVisiblePosition();
		listView.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem > prevFirstItemPosition) activity.hideFAB();
				else activity.showFAB();
			}
		});
		return V;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = (MainActivity) activity;
	}
}
