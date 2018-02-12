package com.gumei.groupbuy.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gumei.groupbuy.CityChooseActivity;
import com.gumei.groupbuy.GoodsDetialActivity;
import com.gumei.groupbuy.MaketListActivity;
import com.gumei.groupbuy.GroupListActivity;
import com.gumei.groupbuy.MainActivity;
import com.gumei.groupbuy.MoiveListActivity;
import com.gumei.groupbuy.R;
import com.gumei.groupbuy.adapter.HomeAdapter;
import com.gumei.groupbuy.scan.MipcaActivityCapture;
import com.gumei.groupbuy.util.MyTool;

public class HomeFragment extends Fragment implements OnClickListener {
	MainActivity activity;
	private ViewPager mViewPager;
	private ViewPager menu_pager;
	ListView home_listview;
	HomeAdapter adapter;
	LinearLayout dot;

	TextView home_scaning;

	LinearLayout change_city;

	private final static int SCANNIN_GREQUEST_CODE = 1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity = (MainActivity) getActivity();
		View conventview = inflater.inflate(R.layout.fragment_main, null);
		mViewPager = (ViewPager) conventview
				.findViewById(R.id.whatsnew_viewpager);
		menu_pager = (ViewPager) conventview.findViewById(R.id.menu_pager);
		home_listview = (ListView) conventview.findViewById(R.id.home_listview);
		home_scaning = (TextView) conventview.findViewById(R.id.home_scaning);
		change_city = (LinearLayout) conventview.findViewById(R.id.change_city);
		change_city.setOnClickListener(this);
		home_scaning.setOnClickListener(this);

		conventview.findViewById(R.id.home_moive1).setOnClickListener(this);
		conventview.findViewById(R.id.home_group_list1)
				.setOnClickListener(this);
		conventview.findViewById(R.id.home_group_list2)
				.setOnClickListener(this);
		dot = (LinearLayout) conventview.findViewById(R.id.dot);
		final ArrayList<View> views = new ArrayList<View>();
		for (int i = 0; i < 3; i++) {
			ImageView child = new ImageView(activity);
			child.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			child.setPadding(5, 5, 5, 5);
			child.setImageResource(R.drawable.point_off);
			dot.addView(child);
			ImageView imageView = new ImageView(activity);
			imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(activity,
							GoodsDetialActivity.class);
					startActivity(intent);

				}
			});
			imageView.setBackgroundResource(R.drawable.title_pic);
			imageView.setLayoutParams(new LayoutParams(
					LayoutParams.MATCH_PARENT, 280));
			views.add(imageView);
		}
		((ImageView) dot.getChildAt(0)).setImageResource(R.drawable.point_on);
		PagerAdapter mPagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(views.get(position));
			}

			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}
		};

		mViewPager.setAdapter(mPagerAdapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				for (int i = 0; i < dot.getChildCount(); i++) {
					((ImageView) dot.getChildAt(i))
							.setImageResource(R.drawable.point_off);
				}
				((ImageView) dot.getChildAt(arg0))
						.setImageResource(R.drawable.point_on);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		// µÚ¶þ¿éviewpager
		final List<View> list = new ArrayList<View>();
		LayoutInflater mLi = LayoutInflater.from(activity);
		View view1 = mLi.inflate(R.layout.viewpager_main_menu1, null);
		view1.findViewById(R.id.home1_type1).setOnClickListener(this);
		view1.findViewById(R.id.home1_type2).setOnClickListener(this);
		view1.findViewById(R.id.home1_type3).setOnClickListener(this);
		view1.findViewById(R.id.home1_type4).setOnClickListener(this);
		view1.findViewById(R.id.home1_type5).setOnClickListener(this);
		view1.findViewById(R.id.home1_type6).setOnClickListener(this);
		view1.findViewById(R.id.home1_type7).setOnClickListener(this);
		view1.findViewById(R.id.home1_type8).setOnClickListener(this);
		list.add(view1);
		View view2 = mLi.inflate(R.layout.viewpager_main_menu2, null);
		view2.findViewById(R.id.home2_type1).setOnClickListener(this);
		view2.findViewById(R.id.home2_type2).setOnClickListener(this);
		view2.findViewById(R.id.home2_type3).setOnClickListener(this);
		view2.findViewById(R.id.home2_type4).setOnClickListener(this);
		view2.findViewById(R.id.home2_type5).setOnClickListener(this);
		view2.findViewById(R.id.home2_type6).setOnClickListener(this);
		view2.findViewById(R.id.home2_type7).setOnClickListener(this);
		view2.findViewById(R.id.home2_type8).setOnClickListener(this);
		list.add(view2);

		PagerAdapter pagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return list.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(list.get(position));
			}

			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager) container).addView(list.get(position));
				return list.get(position);
			}
		};
		menu_pager.setAdapter(pagerAdapter);

		// listview
		adapter = new HomeAdapter(activity);
		home_listview.setAdapter(adapter);
		MyTool.setListViewHeightBasedOnChildren(home_listview);
		home_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(activity, GoodsDetialActivity.class);
				startActivity(intent);

			}
		});

		return conventview;
	}

	int intent_type;

	@Override
	public void onClick(View view) {
		Intent intent;
		switch (view.getId()) {
		case R.id.home_scaning:
			intent = new Intent();
			intent.setClass(activity, MipcaActivityCapture.class);
			// startActivity(intent);
			startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
			break;
		case R.id.change_city:
			intent = new Intent(activity, CityChooseActivity.class);
			startActivity(intent);
			break;

		case R.id.home1_type1:
			intent_type = MaketListActivity.TYPE_FOOD;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home1_type2:
			intent_type = MaketListActivity.TYPE_MOIVE;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home1_type3:
			intent_type = MaketListActivity.TYPE_KTV;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home1_type4:
			intent_type = MaketListActivity.TYPE_HOTEL;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home1_type5:
			intent_type = MaketListActivity.TYPE_COSMETOLOGY;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home1_type6:
			intent_type = MaketListActivity.TYPE_WENDDING;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home1_type7:
			intent_type = MaketListActivity.TYPE_NEW_ORDER;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home1_type8:
			intent_type = MaketListActivity.TYPE_MORE;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type1:
			intent_type = MaketListActivity.TYPE_APPOINTMENT;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type2:
			intent_type = MaketListActivity.TYPE_PARTY;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type3:
			intent_type = MaketListActivity.TYPE_WEEKDAY;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type4:
			intent_type = MaketListActivity.TYPE_TOWN;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type5:
			intent_type = MaketListActivity.TYPE_WOMAN;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type6:
			intent_type = MaketListActivity.TYPE_FARTHER;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type7:
			intent_type = MaketListActivity.TYPE_SHOOT;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home2_type8:
			intent_type = MaketListActivity.TYPE_LIFE;
			intent = new Intent(activity, MaketListActivity.class);
			intent.putExtra("intent_type", intent_type);
			startActivity(intent);
			break;
		case R.id.home_moive1:
			intent = new Intent(activity, MoiveListActivity.class);
			startActivity(intent);
			break;
		case R.id.home_group_list1:
			intent = new Intent(activity, GroupListActivity.class);
			startActivity(intent);
			break;
		case R.id.home_group_list2:
			intent = new Intent(activity, GroupListActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}
}
