package com.ladhari.adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;

import com.ladhari.objects.Equipement;
import com.sbox.hack4good.R;

public class EquipementItemAdapter extends BaseAdapter {

	private ArrayList<Equipement> Equipements;
	private LayoutInflater myInflater;

	public EquipementItemAdapter(Context context, ArrayList<Equipement> _Equipements) {
		this.myInflater = LayoutInflater.from(context);
		this.Equipements = _Equipements;
	}

	
	public int getCount() {
		return this.Equipements.size();
	}

	
	public Object getItem(int arg0) {
		return this.Equipements.get(arg0);
	}

	
	public long getItemId(int position) {
		return position;
	}

	public static class ViewHolder {
		TextView name ;
		Switch status;
		
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.room_equipement_item, null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.name_eq);
			holder.status = (Switch) convertView.findViewById(R.id.status_eq);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name.setText(Equipements.get(position).getName());
		if (Equipements.get(position).getStatus().equals("off")) {
			holder.status.setTag(Equipements.get(position).getData());
			holder.status.setChecked(false);	
		}
		if (Equipements.get(position).getStatus().equals("on")) {
			holder.status.setTag(Equipements.get(position).getData());

			holder.status.setChecked(true);	
		}
holder.status.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		Switch s=(Switch) buttonView;
		SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
		if (isChecked) {
			sendPostReqAsyncTask.execute(s.getTag()+"on");	
			System.out.println();
		} else {
			sendPostReqAsyncTask.execute(s.getTag()+"off");	
		}
		
		
		
	}
});
		return convertView;

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

//			@Override
//			protected void onPostExecute(String result) {
//				super.onPostExecute(result);
//
//				if (result.equals("working")) {
//					Toast.makeText(myInflater.getContext(),
//							"HTTP POST is working...", Toast.LENGTH_LONG).show();
//				} else {
//					Toast.makeText(myInflater.getContext(), "Invalid POST req...",
//							Toast.LENGTH_LONG).show();
//				}
//			}
		}
}
