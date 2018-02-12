package com.gumei.groupbuy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.gumei.groupbuy.adapter.OrderAdapter;
import com.gumei.groupbuy.util.MyTool;

public class OrderComfirmActivity extends Activity implements OnClickListener {
	ListView listView;
	OrderAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_confirm);
		listView = (ListView) findViewById(R.id.listview);
		adapter = new OrderAdapter(this);
		listView.setAdapter(adapter);
		MyTool.setListViewHeightBasedOnChildren(listView);
		findViewById(R.id.send_order).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.send_order:
			Intent intent = new Intent(this, OrderSuccessfulActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

}
