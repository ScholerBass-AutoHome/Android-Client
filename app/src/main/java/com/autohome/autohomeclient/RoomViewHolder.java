package com.autohome.autohomeclient;

import android.view.View;
import android.widget.TextView;

import com.twotoasters.android.support.v7.widget.CardView;
import com.twotoasters.android.support.v7.widget.RecyclerView;

/**
 * Created by benscholer on 3/6/15.
 */
public class RoomViewHolder extends RecyclerView.ViewHolder {
	public final CardView cardView;
	public final TextView textView;

	public RoomViewHolder(View itemView) {
		super(itemView);
		cardView = (CardView) itemView;
		cardView.setRadius(4);

		textView = (TextView) cardView.getChildAt(0);
	}
}
