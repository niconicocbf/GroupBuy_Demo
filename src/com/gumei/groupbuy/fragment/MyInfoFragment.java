package com.gumei.groupbuy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.gumei.groupbuy.MainActivity;
import com.gumei.groupbuy.MyOrderActivity;
import com.gumei.groupbuy.MyPurseActivity;
import com.gumei.groupbuy.R;

public class MyInfoFragment extends Fragment implements OnClickListener {
	MainActivity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = (MainActivity) getActivity();
		View conventview = inflater.inflate(R.layout.fragment_myinfo, null);
		conventview.findViewById(R.id.setting1).setOnClickListener(this);
		conventview.findViewById(R.id.setting2).setOnClickListener(this);
		conventview.findViewById(R.id.setting3).setOnClickListener(this);
		conventview.findViewById(R.id.setting4).setOnClickListener(this);
		conventview.findViewById(R.id.setting5).setOnClickListener(this);
		conventview.findViewById(R.id.setting6).setOnClickListener(this);
		return conventview;
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.title_pad:
			break;
		case R.id.setting1:
			intent = new Intent(activity, MyPurseActivity.class);
			startActivity(intent);
			break;
		case R.id.setting2:
			intent = new Intent(activity, MyOrderActivity.class);
			startActivity(intent);
			break;
		case R.id.setting3:
			
			break;
		case R.id.setting4:
			break;
		case R.id.setting5:
			break;
		case R.id.setting6:
			break;
		default:
			break;
		}

	}
}
