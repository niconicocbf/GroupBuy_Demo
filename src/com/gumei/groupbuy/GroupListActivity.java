package com.gumei.groupbuy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.gumei.groupbuy.adapter.GroupListadapter;

public class GroupListActivity extends Activity {
	ListView listView;
	GroupListadapter groupListadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_list);
		listView = (ListView) findViewById(R.id.listview);
		groupListadapter = new GroupListadapter(this);
		listView.setAdapter(groupListadapter);
		
	}
}
