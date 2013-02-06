package com.example.tabpage;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TabHost tabHost = getTabHost();// 选项卡
		
		// 新意图
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Download")// 跳到Download_Save
				.setContent(new Intent(MainActivity.this, Download_Save.class)));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("ShowListView")// 跳到ShowLV
				.setContent(new Intent(MainActivity.this, Load_Image.class)));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("ShowImage")// 跳到ShowImg
				.setContent(new Intent(MainActivity.this, ShowImg.class)));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
