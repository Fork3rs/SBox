package com.ladhari.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladhari.objects.Room;
import com.sbox.hack4good.R;

public class RoomItemAdapter extends BaseAdapter {

	private ArrayList<Room> Rooms;
	private LayoutInflater myInflater;

	public RoomItemAdapter(Context context, ArrayList<Room> _Rooms) {
		this.myInflater = LayoutInflater.from(context);
		this.Rooms = _Rooms;
	}

	
	public int getCount() {
		return this.Rooms.size();
	}

	
	public Object getItem(int arg0) {
		return this.Rooms.get(arg0);
	}

	
	public long getItemId(int position) {
		return position;
	}

	public static class ViewHolder {
		TextView name ;
		TextView device_number;
		TextView notifications_number;

		ImageView img;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.room_item, null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.txtName);
			holder.device_number = (TextView) convertView.findViewById(R.id.txtNbrDevice);
			holder.notifications_number = (TextView) convertView.findViewById(R.id.notifications_id);
			holder.img = (ImageView) convertView.findViewById(R.id.images);


			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name.setText(Rooms.get(position).getName());
		holder.device_number.setText(Rooms.get(position).getDevices_number()+" Devices");
		holder.notifications_number.setText(Rooms.get(position).getNotifications_number()+" Notifications");
		holder.img.setImageResource(Rooms.get(position).getId());
		return convertView;

	}

}
