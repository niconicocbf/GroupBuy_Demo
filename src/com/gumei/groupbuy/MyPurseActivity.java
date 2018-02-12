package com.gumei.groupbuy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MyPurseActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_pur);
		findViewById(R.id.my_pur_item1).setOnClickListener(this);
		findViewById(R.id.my_pur_item2).setOnClickListener(this);
		findViewById(R.id.my_pur_item3).setOnClickListener(this);
		findViewById(R.id.my_pur_item4).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_pur_item1:

			break;
		case R.id.my_pur_item2:

			break;
		case R.id.my_pur_item3:

			break;
		case R.id.my_pur_item4:

			break;

		default:
			break;
		}

	}
}
