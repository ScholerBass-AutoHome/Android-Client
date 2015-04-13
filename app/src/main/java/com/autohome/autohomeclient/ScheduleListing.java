package com.autohome.autohomeclient;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ScheduleListing extends Fragment {

	ListView listView;
	ArrayList<ScheduleInstance> scheduleInstances = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		Resources res = getResources();

		for (int i = 0; i < 10; i++) {
			scheduleInstances.add(new ScheduleInstance("Alarm " + i, new Date(2015, 4, 13, 13 + i, 5),
					new Date(2015, 4, 13, 14 + i, 0), new boolean[]{true, true, true, true, true, true, true},
							true, true, null));
		}

		View V = inflater.inflate(R.layout.fragment_schedule_listing, container, false);

		listView = (ListView) V.findViewById(R.id.schedule_list);

		ScheduleAdapter adapter = new ScheduleAdapter(super.getActivity(), scheduleInstances, res);

		listView.setAdapter(adapter);

		return V;
	}

}
