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
	 * ����չʾ��ҳ��ragment
	 */
	private HomeFragment homeFragment;

	/**
	 * ����չʾ������Fragment
	 */
	private NearFragment nearFragment;

	/**
	 * ����չʾ�����Fragment
	 */
	private FindFragment findFragment;

	/**
	 * ����չʾ���ﳵ��Fragment
	 */
	private GroupFragment groupFragment;
	
	/**
	 * ����չʾ�ҵ��յ��Fragment
	 */
	private MyInfoFragment myInfoFragment;

	// ////////////////////////////////////////////////
	private ImageView homeImage;

	/**
	 * ��Tab��������ʾ����ͼ��Ŀؼ�
	 */
	private ImageView searchImage;

	/**
	 * ��Tab��������ʾ����ͼ��Ŀؼ�
	 */
	private ImageView sortImage;

	/**
	 * ��Tab��������ʾ���ﳵͼ��Ŀؼ�
	 */
	private ImageView shoppingImage;
	/**
	 * ��Tab��������ʾ�ҵ��յ�ͼ��Ŀؼ�
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
		// ��һ������ʱѡ�е�0��tab
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
		// ������Ѷ������ʾ��һ��fragment
		// currentItem = 0;
		switch (v.getId()) {
		case R.id.home_image:

			// �������̥�ļ��tabʱ��ѡ�е�1��tab
			setTabSelection(0);
			break;
		case R.id.search_image:
			// �����������tabʱ��ѡ�е�2��tab
			setTabSelection(1);
			break;
		case R.id.fenlei_image:
			// ������˻�����ѯtabʱ��ѡ�е�3��tab
			setTabSelection(2);
			break;
		case R.id.shopping_image:
			// ������˸���tabʱ��ѡ�е�4��tab
			setTabSelection(3);
			break;
		case R.id.money_image:
			// ������˸���tabʱ��ѡ�е�4��tab
			setTabSelection(4);
			break;
		default:
			break;
		}
	}

	/**
	 * ���ݴ����index����������ѡ�е�tabҳ��
	 * 
	 * @param index
	 *            ÿ��tabҳ��Ӧ���±ꡣ0��ʾ̥�ļ�⣬1��ʾ���֣�2��ʾ������ѯ��3��ʾ���ࡣ
	 */
	public void setTabSelection(int index) {
		// ÿ��ѡ��֮ǰ��������ϴε�ѡ��״̬
		clearSelection();
		// ����һ��Fragment����

		// fragmentManager.beginTransaction().replace(R.id.content, new
		// FetalHeartFragment()).commit();
		transaction = fragmentManager.beginTransaction();

		hideFragment(transaction);
		switch (index) {
		case 0:
			// ���������ҳtabʱ���ı�ؼ���ͼƬ
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
			// �����������tabʱ���ı�ؼ���ͼƬ
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
			// ������˷���tabʱ���ı�ؼ���ͼƬ
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
			// ������˹��ﳵtabʱ���ı�ؼ���ͼƬ
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
			// ��������ҵ��յ�tabʱ���ı�ؼ���ͼƬ
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
	 * �������е�fragment
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
	 * ��������е�ѡ��״̬��
	 */
	private void clearSelection() {
		homeImage.setImageResource(R.drawable.main1_off);
		searchImage.setImageResource(R.drawable.main2_off);
		sortImage.setImageResource(R.drawable.main3_off);
		shoppingImage.setImageResource(R.drawable.main4_off);
		myaccountImage.setImageResource(R.drawable.main5_off);
	}

}
