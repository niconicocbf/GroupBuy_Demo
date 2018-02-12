package com.gumei.groupbuy.fragment;

import com.gumei.groupbuy.MaketListActivity;
import com.gumei.groupbuy.MainActivity;
import com.gumei.groupbuy.MapActivity;
import com.gumei.groupbuy.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class NearFragment extends Fragment implements OnClickListener {
	MainActivity activity;
	TextView near_map;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = (MainActivity) getActivity();
		View conventview = inflater.inflate(R.layout.fragment_near, null);
		near_map = (TextView) conventview.findViewById(R.id.near_map);
		near_map.setOnClickListener(this);
		conventview.findViewById(R.id.home_type1).setOnClickListener(this);
		conventview.findViewById(R.id.home_type2).setOnClickListener(this);
		conventview.findViewById(R.id.home_type3).setOnClickListener(this);
		conventview.findViewById(R.id.home_type4).setOnClickListener(this);
		conventview.findViewById(R.id.home_type5).setOnClickListener(this);
		conventview.findViewById(R.id.home_type6).setOnClickListener(this);
		conventview.findViewById(R.id.home_type7).setOnClickListener(this);
		conventview.findViewById(R.id.home_type8).setOnClickListener(this);
		return conventview;
	}

	int intent_type;

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.near_map:
			intent = new Intent(activity, MapActivity.class);
			activity.startActivity(intent);
			break;
		case R.id.home_type1:
			intent_type = MaketListActivity.TYPE_FOOD;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_type2:
			intent_type = MaketListActivity.TYPE_MOIVE;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_type3:
			intent_type = MaketListActivity.TYPE_KTV;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_type4:
			intent_type = MaketListActivity.TYPE_HOTEL;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_type5:
			intent_type = MaketListActivity.TYPE_COSMETOLOGY;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_type6:
			intent_type = MaketListActivity.TYPE_WENDDING;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_type7:
			intent_type = MaketListActivity.TYPE_NEW_ORDER;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_type8:
			intent_type = MaketListActivity.TYPE_MORE;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
