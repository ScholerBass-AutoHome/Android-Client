package com.autohome.autohomeclient;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.support.v7.widget.SwitchCompat;
import android.widget.TextView;



import java.util.ArrayList;

/**
 * Created by benscholer on 4/12/15.
 */
public class ScheduleAdapter extends BaseAdapter {

	/**
	 * ******** Declare Used Variables ********
	 */
	private Activity activity;
	private ArrayList data;
	private static LayoutInflater inflater = null;
	public Resources res;
	ScheduleInstance tempValues = null;
	int i = 0;

	/**
	 * **********  CustomAdapter Constructor ****************
	 */
	public ScheduleAdapter(Activity a, ArrayList d, Resources resLocal) {

		/********** Take passed values **********/
		activity = a;
		data = d;
		res = resLocal;

		/***********  Layout inflator to call external xml layout () ***********/
		inflater = (LayoutInflater) activity.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	/**
	 * ***** What is the size of Passed Arraylist Size ***********
	 */
	@Override
	public int getCount() {

		if (data.size() <= 0)
			return 1;
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public static class ViewHolder {

		public TextView startScheduleTimeText;
		public TextView startScheduleAMPM;
		public TextView endScheduleTimeText;
		public TextView endScheduleAMPM;
		public TextView name;
		public SwitchCompat aSwitch;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		ViewHolder holder;

		if (convertView == null) {

			/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
			vi = inflater.inflate(R.layout.schedule_listing_list_item, null);

			/****** View Holder Object to contain tabitem.xml file elements ******/

			holder = new ViewHolder();
			holder.startScheduleTimeText = (TextView) vi.findViewById(R.id.start_schedule_time_text);
			holder.startScheduleAMPM = (TextView) vi.findViewById(R.id.start_schedule_ampm);
			holder.endScheduleTimeText = (TextView) vi.findViewById(R.id.end_schedule_time_text);
			holder.endScheduleAMPM = (TextView) vi.findViewById(R.id.end_schedule_ampm);
			holder.name = (TextView) vi.findViewById(R.id.schedule_item_name);
			holder.aSwitch = (SwitchCompat) vi.findViewById(R.id.schedule_switch);

			/************  Set holder with LayoutInflater ************/
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();

		if (data.size() <= 0) {
			holder.name.setText("No Data");
			//TODO change this so it doesn't suck.

		} else {
			/***** Get each Model object from Arraylist ********/
			tempValues = null;
			tempValues = (ScheduleInstance) data.get(position);

			/************  Set Model values in Holder elements ***********/

			holder.startScheduleTimeText.setText(tempValues.start.toPrettyString()[0]);
			holder.startScheduleAMPM.setText(tempValues.start.toPrettyString()[1]);
			holder.endScheduleTimeText.setText(tempValues.end.toPrettyString()[0]);
			holder.endScheduleAMPM.setText(tempValues.end.toPrettyString()[1]);
			holder.name.setText(tempValues.name);
			holder.aSwitch.setChecked(tempValues.status);

			/******** Set Item Click Listner for LayoutInflater for each row *******/

		}
		return vi;
	}
}
