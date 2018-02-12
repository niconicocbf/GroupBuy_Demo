package com.gumei.groupbuy;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class MapActivity extends Activity {
	private BMapManager mBMapMan;
	MapView bmapsView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBMapMan = new BMapManager(this);
		mBMapMan.init("W3AzzqOoNGlRoA3k1c5p8cUM", null);
		setContentView(R.layout.activity_map);
		bmapsView = (MapView) findViewById(R.id.bmapsView);

		bmapsView.setBuiltInZoomControls(true);
		// 设置启用内置的缩放控件
		MapController mMapController = bmapsView.getController();
		// 得到mMapView的控制权,可以用它控制和驱动平移和缩放
		GeoPoint point = new GeoPoint((int) (39.915 * 1E6),
				(int) (116.404 * 1E6));
		// 用给定的经纬度构造一个GeoPoint，单位是微度 (度 * 1E6)
		mMapController.setCenter(point);// 设置地图中心点
		mMapController.setZoom(13);// 设置地图zoom级别
		bmapsView.setTraffic(true);
	}

	@Override
	protected void onPause() {
		bmapsView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		bmapsView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		bmapsView.destroy();
//		 unregisterReceiver(myBr);
		super.onDestroy();
//		android.os.Process
//		.killProcess(android.os.Process.myPid());
	}
}
