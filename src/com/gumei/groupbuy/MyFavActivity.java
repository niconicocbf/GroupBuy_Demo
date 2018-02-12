package com.gumei.groupbuy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;

public class MyFavActivity extends Activity implements OnClickListener {
	ExpandableListView listview;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_fav);
		listview=(ExpandableListView) findViewById(R.id.listview);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_pad_show:
			
			break;
		default:
			break;
		}

	}
}
