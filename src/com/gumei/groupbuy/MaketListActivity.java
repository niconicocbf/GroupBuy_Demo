package com.gumei.groupbuy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.gumei.groupbuy.adapter.GoodsListAdapter;

public class MaketListActivity extends Activity implements OnClickListener {
	GoodsListAdapter adapter;
	ListView listView;

	public static final int TYPE_NEAR = 1;
	public static final int TYPE_FOOD = 2;
	public static final int TYPE_MOIVE = 3;
	public static final int TYPE_KTV = 4;
	public static final int TYPE_HOTEL = 5;
	public static final int TYPE_COSMETOLOGY = 6;
	public static final int TYPE_WENDDING = 7;
	public static final int TYPE_NEW_ORDER = 8;
	public static final int TYPE_MORE = 9;
	public static final int TYPE_APPOINTMENT = 10;
	public static final int TYPE_PARTY = 11;
	public static final int TYPE_WEEKDAY = 12;
	public static final int TYPE_TOWN = 13;
	public static final int TYPE_WOMAN = 14;
	public static final int TYPE_FARTHER = 15;
	public static final int TYPE_SHOOT = 16;
	public static final int TYPE_LIFE = 17;

	TextView near_map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_list);
		listView = (ListView) findViewById(R.id.listview);
		adapter = new GoodsListAdapter(this);
		listView.setAdapter(adapter);

		near_map = (TextView) findViewById(R.id.near_map);
		near_map.setOnClickListener(this);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(MaketListActivity.this,
						MaketDetialActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.near_map:
			Intent intent = new Intent(this, MapActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

}
