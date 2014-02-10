package com.sbox.hack4good;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ladhari.adapters.RoomItemAdapter;
import com.ladhari.menu.Splinky_menu_Activity;
import com.ladhari.objects.Room;

public class HouseActivity extends Splinky_menu_Activity {
	
	ArrayList<Room> rooms = new ArrayList<Room>();
	
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	setContentView(R.layout.house);
	
	  
	  rooms.add(new Room(R.drawable.bathroom,"Bathroom",1,4));
	  rooms.add(new Room(R.drawable.balcony,"Balcony",1,2));
	  rooms.add(new Room(R.drawable.livingroom,"Living Room",3,1));
	  rooms.add(new Room(R.drawable.bedroom,"Bedroom",6,7));
	  rooms.add(new Room(R.drawable.diningroom,"Dining Room",4,1));
	  rooms.add(new Room(R.drawable.kids,"Kids Room",4,11));
	  rooms.add(new Room(R.drawable.kitchen,"kitchen",2,5));
	  
	  
      ListView list = (ListView) this.findViewById(R.id.listroom);
      RoomItemAdapter adpt = new RoomItemAdapter(this,rooms);
      
      list.setAdapter(adpt);
      list.setOnItemClickListener(new OnItemClickListener()
      {
    	  
    	   public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long id) {
    		   Room room =(Room) parent.getAdapter().getItem(position);
    		  
   		  // Toast.makeText(HouseActivity.this, room.getName(), Toast.LENGTH_LONG).show();
//   		   if (room.getName().equals("Bedroom")) {
//   			Intent intent = new Intent(HouseActivity.this, EquipementActivity.class);
// 		   intent.putExtra("room_name", room.getName());
//            startActivity(intent);
//            
//		}else{
    		   Intent intent = new Intent(HouseActivity.this, RoomActivity.class);
    		   intent.putExtra("room_name", room.getName());
    		   intent.putExtra("room_img", room.getId());
    		   

               startActivity(intent);
               
//		}
				
			}
    	});
}
}
