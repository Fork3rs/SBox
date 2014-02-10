package com.sbox.hack4good;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.ladhari.menu.Splinky_menu_Activity;
import com.ladhari.objects.Equipement;
import com.touchmenotapps.widget.radialmenu.progress.widget.RadialProgressWidget;

public class RoomActivity extends Splinky_menu_Activity {
	ArrayList<Equipement> Equipements = new ArrayList<Equipement>();

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bedroom);
		RelativeLayout marker1lay = (RelativeLayout) this.findViewById(R.id.marker1lay);
		RelativeLayout marker2lay = (RelativeLayout) this.findViewById(R.id.marker2lay);
		RelativeLayout marker3lay = (RelativeLayout) this.findViewById(R.id.marker3lay);
		/*Set Tags in layouts*/
		if (this.getIntent().getExtras().getString("room_name").equals("Balcony")) {
			marker1lay.setPadding(0, 370, 60, 0);
			marker2lay.setPadding(250, 80, 30, 0);
			marker3lay.setVisibility(View.INVISIBLE);

		}else if (this.getIntent().getExtras().getString("room_name").equals("Bedroom")) {
			marker1lay.setPadding(0, 190, 30, 0);
			marker2lay.setPadding(310, 190, 0, 0);
			marker3lay.setVisibility(View.INVISIBLE);
		}else if (this.getIntent().getExtras().getString("room_name").equals("Bathroom")) {
			marker1lay.setPadding(0, 190, 30, 0);
			marker2lay.setPadding(310, 190, 0, 0);
			marker3lay.setPadding(0, 370, 60, 0);
		}else if (this.getIntent().getExtras().getString("room_name").equals("Dining Room")) {
			marker1lay.setPadding(0, 165, 60, 0);
			marker2lay.setVisibility(View.INVISIBLE);
			marker3lay.setVisibility(View.INVISIBLE);
		}
		else if (this.getIntent().getExtras().getString("room_name").equals("Living Room")) {
			marker1lay.setPadding(0, 265, 60, 0);
			marker2lay.setPadding(120, 365, 0, 0);
			marker3lay.setPadding(0, 60, 130, 0);
		}else{
			marker1lay.setVisibility(View.INVISIBLE);
			marker2lay.setVisibility(View.INVISIBLE);
			marker3lay.setVisibility(View.INVISIBLE);
		}
		ImageView img = (ImageView) this.findViewById(R.id.imageView1);
		img.setImageResource(this.getIntent().getExtras().getInt("room_img"));
		ImageView marker1 = (ImageView) this.findViewById(R.id.marker1);
		ImageView marker2 = (ImageView) this.findViewById(R.id.marker2);
		ImageView marker3 = (ImageView) this.findViewById(R.id.marker3);

		if (this.getIntent().getExtras().getString("room_name").equals("Living Room")) {
			marker2.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					
		AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
		
				    LayoutInflater inflater = RoomActivity.this.getLayoutInflater();
				    View v1=inflater.inflate(R.layout.modal_light, null);
				    builder.setView(v1);
				    AlertDialog dialog = builder.create();
				    LinearLayout view = (LinearLayout) v1.findViewById(R.id.view_light_modal);
				    view.setBackgroundResource(getIntent().getExtras().getInt("room_img"));
				    RadialProgressWidget temperature = (RadialProgressWidget) v1.findViewById(R.id.temperature_modal);
				    temperature.setVisibility(View.VISIBLE);
				    temperature.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER_VERTICAL));
					SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
					
					try {
						String a=sendPostReqAsyncTask.execute("inall").get();
if (a!=null) {
						
						
						int tmp=Integer.parseInt(a.split("/")[0]);
						
					    temperature.setCurrentValue((int)(tmp/2.2));
}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		
//		    		sendPostReqAsyncTask.g
		    		
				    SeekBar seek= (SeekBar) v1.findViewById(R.id.seekBar1);
				    seek.setVisibility(View.INVISIBLE);
				    ImageView img2= (ImageView) v1.findViewById(R.id.modal_img);
				    img2.setVisibility(View.INVISIBLE);

				   // seek.setLayoutParams(new LinearLayout.LayoutParams(200, 200, Gravity.CENTER));
					dialog.show();
					
				}
			});
			marker3.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					
		AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
		
				    LayoutInflater inflater = RoomActivity.this.getLayoutInflater();
				    View v1=inflater.inflate(R.layout.modal_light, null);
				    builder.setView(v1);
				    AlertDialog dialog = builder.create();
				    LinearLayout view = (LinearLayout) v1.findViewById(R.id.view_light_modal);
				    view.setBackgroundResource(getIntent().getExtras().getInt("room_img"));
				    ImageView img = (ImageView) v1.findViewById(R.id.modal_img);
				  
				    /*Static tags*/  
		        	
				    img.setTag("off");
				    img.setImageResource(R.drawable.light2);
					img.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
//							Log.d("a", v.getTag()+"");
				    		SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
			    			ImageView img = (ImageView) v.findViewById(R.id.modal_img);

				    		if (v.getTag().equals("on")) {
				    			img.setImageResource(R.drawable.light2);

					        	Toast.makeText(v.getContext(), "Closing", Toast.LENGTH_SHORT).show();
					        	v.setTag("off");
				    			sendPostReqAsyncTask.execute("od0off");	
				    		} else {
				    			img.setImageResource(R.drawable.light);
					        	Toast.makeText(v.getContext(), "Opening", Toast.LENGTH_SHORT).show();
				    			sendPostReqAsyncTask.execute("od0on");	
				    			v.setTag("on");
				    		}
				        	
						}
						});
					
					   /*Static tags*/
					dialog.show();
					
				}
			});
			marker1.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					
		AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
		
				    LayoutInflater inflater = RoomActivity.this.getLayoutInflater();
				    View v1=inflater.inflate(R.layout.modal_light, null);
				    builder.setView(v1);
				    AlertDialog dialog = builder.create();
				    LinearLayout view = (LinearLayout) v1.findViewById(R.id.view_light_modal);
				    view.setBackgroundResource(getIntent().getExtras().getInt("room_img"));
				    ImageView img = (ImageView) v1.findViewById(R.id.modal_img);
				    img.setImageResource(R.drawable.tv);
				    ImageView remote = (ImageView) v1.findViewById(R.id.modal_img_remote);
					remote.setImageResource(R.drawable.remote);
					SeekBar seek= (SeekBar) v1.findViewById(R.id.seekBar1);
					seek.setVisibility(View.INVISIBLE);

					dialog.show();
					
				}
			});
		}else{
		marker1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
	AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
	
			    LayoutInflater inflater = RoomActivity.this.getLayoutInflater();
			    View v1=inflater.inflate(R.layout.modal_light, null);
			    builder.setView(v1);
			    AlertDialog dialog = builder.create();
			    LinearLayout view = (LinearLayout) v1.findViewById(R.id.view_light_modal);
			    view.setBackgroundResource(getIntent().getExtras().getInt("room_img"));
			    ImageView img = (ImageView) v1.findViewById(R.id.modal_img);
			  
			    /*Static tags*/  
	        	
			    img.setTag("off");
			    img.setImageResource(R.drawable.light2);
				img.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
//						Log.d("a", v.getTag()+"");
			    		SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
		    			ImageView img = (ImageView) v.findViewById(R.id.modal_img);

			    		if (v.getTag().equals("on")) {
			    			img.setImageResource(R.drawable.light2);

				        	Toast.makeText(v.getContext(), "Closing", Toast.LENGTH_SHORT).show();
				        	v.setTag("off");
			    			sendPostReqAsyncTask.execute("od0on");	
			    		} else {
			    			img.setImageResource(R.drawable.light);
				        	Toast.makeText(v.getContext(), "Opening", Toast.LENGTH_SHORT).show();
			    			sendPostReqAsyncTask.execute("od0off");	
			    			v.setTag("on");
			    		}
			        	
					}
					});
				
				   /*Static tags*/
				dialog.show();
				
			}
		});
		
//not living room
		}
	}

}
class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... params) {

		String data = params[0];
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://192.168.1.200:8080/Mobile");
		BasicNameValuePair usernameBasicNameValuePair = new BasicNameValuePair(
				"data", data);
		List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
		nameValuePairList.add(usernameBasicNameValuePair);

		try {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(
					nameValuePairList);
			httpPost.setEntity(urlEncodedFormEntity);

			try {

				HttpResponse httpResponse = httpClient.execute(httpPost);

				InputStream inputStream = httpResponse.getEntity()
						.getContent();

				InputStreamReader inputStreamReader = new InputStreamReader(
						inputStream);

				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader);

				StringBuilder stringBuilder = new StringBuilder();

				String bufferedStrChunk = null;

				while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
					stringBuilder.append(bufferedStrChunk);
				}
				Log.i("a", stringBuilder.toString());
				return stringBuilder.toString();

			} catch (ClientProtocolException cpe) {
				System.out.println("First Exception caz of HttpResponese :"
						+ cpe);
				cpe.printStackTrace();
			} catch (IOException ioe) {
				
				System.out.println("Second Exception caz of HttpResponse :"+ ioe);
				ioe.printStackTrace();
			}

		} catch (UnsupportedEncodingException uee) {
			System.out
					.println("An Exception given because of UrlEncodedFormEntity argument :"
							+ uee);
			uee.printStackTrace();
		}

		return null;
	}


}

