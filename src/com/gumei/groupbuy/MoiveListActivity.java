package com.gumei.groupbuy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.gumei.groupbuy.adapter.MoiveAdapter;

public class MoiveListActivity extends Activity {
	ListView listview;
	MoiveAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moive_list);
		listview = (ListView) findViewById(R.id.listview);
		adapter = new MoiveAdapter(this);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(MoiveListActivity.this,
						MoiveDetialActivity.class);
				startActivity(intent);
			}
		});

	}
}
