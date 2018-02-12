package com.gumei.groupbuy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class OrderSuccessfulActivity extends Activity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_succ);
		findViewById(R.id.group_ticket).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.group_ticket:
			Intent intent = new Intent(this, OrderGroupTicketActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

}
