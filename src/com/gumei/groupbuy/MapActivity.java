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
		// �����������õ����ſؼ�
		MapController mMapController = bmapsView.getController();
		// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		GeoPoint point = new GeoPoint((int) (39.915 * 1E6),
				(int) (116.404 * 1E6));
		// �ø����ľ�γ�ȹ���һ��GeoPoint����λ��΢�� (�� * 1E6)
		mMapController.setCenter(point);// ���õ�ͼ���ĵ�
		mMapController.setZoom(13);// ���õ�ͼzoom����
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
