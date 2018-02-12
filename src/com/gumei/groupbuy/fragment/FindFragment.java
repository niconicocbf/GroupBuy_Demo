package com.gumei.groupbuy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gumei.groupbuy.MainActivity;
import com.gumei.groupbuy.R;
import com.gumei.groupbuy.adapter.FindAdapter;

public class FindFragment extends Fragment implements OnClickListener {
	MainActivity activity;
	ListView find_listview;
	TextView title;
	FindAdapter findAdapter;
	// 选项板
	LinearLayout title_pad, title_pad_show;
	LinearLayout order_title_content1, order_title_content2;
	TextView order_title_dot1, order_title_dot2;
	TextView order_title_text1, order_title_text2;
	boolean isTitlePadShow = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = (MainActivity) getActivity();
		View conventview = inflater.inflate(R.layout.fragment_find, null);
		find_listview = (ListView) conventview.findViewById(R.id.find_listview);
		findAdapter = new FindAdapter(activity);
		find_listview.setAdapter(findAdapter);
		title = (TextView) conventview.findViewById(R.id.title);

		// 选项板
		title_pad = (LinearLayout) conventview.findViewById(R.id.title_pad);
		title_pad.setOnClickListener(this);
		title_pad_show = (LinearLayout) conventview
				.findViewById(R.id.title_pad_show);
		title_pad_show.setOnClickListener(this);
		order_title_content1 = (LinearLayout) conventview
				.findViewById(R.id.order_title_content1);
		order_title_content1.setOnClickListener(this);
		order_title_content2 = (LinearLayout) conventview
				.findViewById(R.id.order_title_content2);
		order_title_content2.setOnClickListener(this);
		order_title_dot1 = (TextView) conventview
				.findViewById(R.id.order_title_dot1);
		order_title_dot2 = (TextView) conventview
				.findViewById(R.id.order_title_dot2);
		order_title_text1 = (TextView) conventview
				.findViewById(R.id.order_title_text1);
		order_title_text2 = (TextView) conventview
				.findViewById(R.id.order_title_text2);
		return conventview;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_pad_show:
			isTitlePadShow = !isTitlePadShow;
			if (isTitlePadShow) {
				title_pad.setVisibility(View.VISIBLE);
			} else {
				title_pad.setVisibility(View.GONE);
			}
			break;
		case R.id.order_title_content1:
			order_title_dot1.setBackgroundResource(R.drawable.main_dot1);
			order_title_dot2.setBackgroundResource(R.drawable.main_dot2);
			order_title_text1.setTextColor(activity.getResources().getColor(
					R.color.title1));
			order_title_text2.setTextColor(activity.getResources().getColor(
					R.color.title2));
			title.setText("品牌");
			// TODO

			break;
		case R.id.order_title_content2:
			order_title_dot1.setBackgroundResource(R.drawable.main_dot2);
			order_title_dot2.setBackgroundResource(R.drawable.main_dot1);
			order_title_text1.setTextColor(activity.getResources().getColor(
					R.color.title2));
			order_title_text2.setTextColor(activity.getResources().getColor(
					R.color.title1));
			title.setText("推荐");
			// TODO
			break;
		case R.id.title_pad:
			title_pad_show.performClick();
			break;
		default:
			break;
		}

	}
}
