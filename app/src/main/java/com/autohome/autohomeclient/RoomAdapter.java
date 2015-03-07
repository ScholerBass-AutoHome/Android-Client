package com.autohome.autohomeclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twotoasters.android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by benscholer on 3/6/15.
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomViewHolder> {

	private List<Room> rooms = new ArrayList<>();

	public RoomAdapter(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void addToList(Room room) {
		int position = 0;
		if (rooms.size() > 1) {
			position = rooms.size();
		}
		rooms.add(position, room);
		notifyItemInserted(position);
	}

	public void removeItemFromList(Room room) {
		int position = rooms.indexOf(room);
		rooms.remove(position);
		notifyItemRemoved(position);
	}

	@Override
	public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.room_list_item, parent, false);
		return new RoomViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RoomViewHolder viewHolder, final int position) {
		final Room room = rooms.get(position);
		viewHolder.textView.setText(room.toString());
		viewHolder.textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				removeItemFromList(room);
			}
		});
	}

	@Override
	public int getItemCount() {
		return rooms.size();
	}
}
