package com.example.tabview;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

	TabHost mTabHost;
	TextView tv1, tv2, tv3;//定义文本变量

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) this.findViewById(R.id.tv1);
		tv1 = (TextView) this.findViewById(R.id.tv2);
		tv1 = (TextView) this.findViewById(R.id.tv3);
		setupTabs();
	}

	private void setupTabs() {

		mTabHost = getTabHost();//调用 TabActivity的getTabHost()方法获取TabHost

		//向TabHost添加三个Tab
		mTabHost.addTab(mTabHost.newTabSpec("tab_1").setIndicator("Download")
				.setContent(R.id.tv1));
		mTabHost.addTab(mTabHost.newTabSpec("tab_2").setIndicator("ListView")
				.setContent(R.id.tv2));
		mTabHost.addTab(mTabHost.newTabSpec("tab_3").setIndicator("Image")
				.setContent(R.id.tv3));
		
		 mTabHost.setOnClickListener(new View.OnClickListener() {
		    	public void onClick(View v) { 
		    		TabChange();//显示下一个页面  
		    	}

				private void TabChange() {
					// TODO Auto-generated method stub
					//。。。。
				}	
	            });
	
	   
	}



}
