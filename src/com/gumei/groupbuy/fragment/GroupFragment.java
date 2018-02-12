package com.gumei.groupbuy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gumei.groupbuy.MainActivity;
import com.gumei.groupbuy.R;
import com.gumei.groupbuy.adapter.GroupAdapter;

public class GroupFragment extends Fragment implements OnClickListener {
	MainActivity activity;
	ListView group_listview;
	GroupAdapter groupAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = (MainActivity) getActivity();
		View conventview = inflater.inflate(R.layout.fragment_group, null);
		group_listview = (ListView) conventview
				.findViewById(R.id.group_listview);
		groupAdapter = new GroupAdapter(activity);
		group_listview.setAdapter(groupAdapter);
		return conventview;
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
