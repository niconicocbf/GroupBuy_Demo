package com.gumei.groupbuy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gumei.groupbuy.R;

public class GoodsListAdapter extends BaseAdapter {
	Context context;

	public GoodsListAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 15;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_goods_item, null);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

	final class ViewHolder {
		TextView reward_title;
		TextView reward_time;
		TextView price;
	}
	
	private void showStar(int index, View view) {
		TextView star01 = (TextView) view.findViewById(R.id.star01);
		TextView star02 = (TextView) view.findViewById(R.id.star02);
		TextView star03 = (TextView) view.findViewById(R.id.star03);
		TextView star04 = (TextView) view.findViewById(R.id.star04);
		TextView star05 = (TextView) view.findViewById(R.id.star05);
		switch (index) {
		case 1:
			star01.setBackgroundResource(R.drawable.star);
			star02.setBackgroundResource(R.drawable.star0);
			star03.setBackgroundResource(R.drawable.star0);
			star04.setBackgroundResource(R.drawable.star0);
			star05.setBackgroundResource(R.drawable.star0);
			break;
		case 2:
			star01.setBackgroundResource(R.drawable.star);
			star02.setBackgroundResource(R.drawable.star);
			star03.setBackgroundResource(R.drawable.star0);
			star04.setBackgroundResource(R.drawable.star0);
			star05.setBackgroundResource(R.drawable.star0);
			break;
		case 3:
			star01.setBackgroundResource(R.drawable.star);
			star02.setBackgroundResource(R.drawable.star);
			star03.setBackgroundResource(R.drawable.star);
			star04.setBackgroundResource(R.drawable.star0);
			star05.setBackgroundResource(R.drawable.star0);
			break;
		case 4:
			star01.setBackgroundResource(R.drawable.star);
			star02.setBackgroundResource(R.drawable.star);
			star03.setBackgroundResource(R.drawable.star);
			star04.setBackgroundResource(R.drawable.star);
			star05.setBackgroundResource(R.drawable.star0);
			break;
		case 5:
			star01.setBackgroundResource(R.drawable.star);
			star02.setBackgroundResource(R.drawable.star);
			star03.setBackgroundResource(R.drawable.star);
			star04.setBackgroundResource(R.drawable.star);
			star05.setBackgroundResource(R.drawable.star);
			break;

		default:
			break;
		}
	}
}
