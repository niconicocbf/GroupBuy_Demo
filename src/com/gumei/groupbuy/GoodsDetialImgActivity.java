package com.gumei.groupbuy;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GoodsDetialImgActivity extends Activity {
	ViewPager mViewPager;
	LinearLayout dot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_good_img);
		mViewPager = (ViewPager) findViewById(R.id.whatsnew_viewpager);
		dot = (LinearLayout) findViewById(R.id.dot);
		final ArrayList<View> views = new ArrayList<View>();
		for (int i = 0; i < 6; i++) {
			ImageView child = new ImageView(this);
			child.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			child.setPadding(5, 5, 5, 5);
			child.setImageResource(R.drawable.point_off);
			dot.addView(child);
			ImageView imageView = new ImageView(this);
			imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

				}
			});
			imageView.setBackgroundResource(R.drawable.good_detial_img);
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

		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

}
