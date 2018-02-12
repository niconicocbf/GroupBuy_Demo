package com.gumei.groupbuy;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.gumei.groupbuy.fragment.FindFragment;
import com.gumei.groupbuy.fragment.GroupFragment;
import com.gumei.groupbuy.fragment.HomeFragment;
import com.gumei.groupbuy.fragment.MyInfoFragment;
import com.gumei.groupbuy.fragment.NearFragment;

public class MainActivity extends FragmentActivity implements OnClickListener {

	/**
	 * 用于展示首页的ragment
	 */
	private HomeFragment homeFragment;

	/**
	 * 用于展示搜索的Fragment
	 */
	private NearFragment nearFragment;

	/**
	 * 用于展示分类的Fragment
	 */
	private FindFragment findFragment;

	/**
	 * 用于展示购物车的Fragment
	 */
	private GroupFragment groupFragment;
	
	/**
	 * 用于展示我的艺典的Fragment
	 */
	private MyInfoFragment myInfoFragment;

	// ////////////////////////////////////////////////
	private ImageView homeImage;

	/**
	 * 在Tab布局上显示搜索图标的控件
	 */
	private ImageView searchImage;

	/**
	 * 在Tab布局上显示分类图标的控件
	 */
	private ImageView sortImage;

	/**
	 * 在Tab布局上显示购物车图标的控件
	 */
	private ImageView shoppingImage;
	/**
	 * 在Tab布局上显示我的艺典图标的控件
	 */
	private ImageView myaccountImage;

	private FragmentManager fragmentManager;
	FragmentTransaction transaction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		fragmentManager = getSupportFragmentManager();
		// 第一次启动时选中第0个tab
		setTabSelection(0);
	}

	private void init() {

		homeImage = (ImageView) findViewById(R.id.home_image);
		searchImage = (ImageView) findViewById(R.id.search_image);
		sortImage = (ImageView) findViewById(R.id.fenlei_image);
		shoppingImage = (ImageView) findViewById(R.id.shopping_image);
		myaccountImage = (ImageView) findViewById(R.id.money_image);
		homeImage.setOnClickListener(this);
		searchImage.setOnClickListener(this);
		sortImage.setOnClickListener(this);
		shoppingImage.setOnClickListener(this);
		myaccountImage.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// 怀孕资讯总是显示第一个fragment
		// currentItem = 0;
		switch (v.getId()) {
		case R.id.home_image:

			// 当点击了胎心监测tab时，选中第1个tab
			setTabSelection(0);
			break;
		case R.id.search_image:
			// 当点击了娱乐tab时，选中第2个tab
			setTabSelection(1);
			break;
		case R.id.fenlei_image:
			// 当点击了怀孕咨询tab时，选中第3个tab
			setTabSelection(2);
			break;
		case R.id.shopping_image:
			// 当点击了更多tab时，选中第4个tab
			setTabSelection(3);
			break;
		case R.id.money_image:
			// 当点击了更多tab时，选中第4个tab
			setTabSelection(4);
			break;
		default:
			break;
		}
	}

	/**
	 * 根据传入的index参数来更多选中的tab页。
	 * 
	 * @param index
	 *            每个tab页对应的下标。0表示胎心监测，1表示娱乐，2表示怀孕咨询，3表示更多。
	 */
	public void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		clearSelection();
		// 开启一个Fragment事务

		// fragmentManager.beginTransaction().replace(R.id.content, new
		// FetalHeartFragment()).commit();
		transaction = fragmentManager.beginTransaction();

		hideFragment(transaction);
		switch (index) {
		case 0:
			// 当点击了首页tab时，改变控件的图片
			homeImage.setImageResource(R.drawable.main1_on);
			if (homeFragment == null) {
				homeFragment = new HomeFragment();
				transaction.add(R.id.content, homeFragment);
			} else {
				transaction.show(homeFragment);
			}
			transaction.commit();
			// }

			break;
		case 1:
			// 当点击了搜索tab时，改变控件的图片
			searchImage.setImageResource(R.drawable.main2_on);
			if (nearFragment == null) {
				nearFragment = new NearFragment();
				transaction.add(R.id.content, nearFragment);
			} else {
				transaction.show(nearFragment);
			}
			transaction.commit();

			break;
		case 2:
			// 当点击了分类tab时，改变控件的图片
			sortImage.setImageResource(R.drawable.main3_on);
			if (findFragment == null) {
				findFragment = new FindFragment();
				transaction.add(R.id.content, findFragment);
			} else {
				transaction.show(findFragment);
			}
			transaction.commit();

			break;
		case 3:
			// 当点击了购物车tab时，改变控件的图片
			shoppingImage.setImageResource(R.drawable.main4_on);
			if (groupFragment == null) {
				groupFragment = new GroupFragment();
				transaction.add(R.id.content, groupFragment);
			} else {
				transaction.show(groupFragment);
			}
			transaction.commit();

			break;
		case 4:
			// 当点击了我的艺典tab时，改变控件的图片
			myaccountImage.setImageResource(R.drawable.main5_on);
			if (myInfoFragment == null) {
				myInfoFragment = new MyInfoFragment();
				transaction.add(R.id.content, myInfoFragment);
			} else {
				transaction.show(myInfoFragment);
			}
			transaction.commit();

			break;
		}

	}

	/**
	 * 隐藏所有的fragment
	 * 
	 * @description
	 * @version 1.0
	 * @author weixi liang
	 * 
	 */
	private void hideFragment(FragmentTransaction transaction) {
		if (homeFragment != null) {
			transaction.hide(homeFragment);
		}
		if (nearFragment != null) {
			transaction.hide(nearFragment);
		}
		if (findFragment != null) {
			transaction.hide(findFragment);
		}
		if (groupFragment != null) {
			transaction.hide(groupFragment);
		}
		if (myInfoFragment != null) {
			transaction.hide(myInfoFragment);
		}
	}

	/**
	 * 清除掉所有的选中状态。
	 */
	private void clearSelection() {
		homeImage.setImageResource(R.drawable.main1_off);
		searchImage.setImageResource(R.drawable.main2_off);
		sortImage.setImageResource(R.drawable.main3_off);
		shoppingImage.setImageResource(R.drawable.main4_off);
		myaccountImage.setImageResource(R.drawable.main5_off);
	}

}
