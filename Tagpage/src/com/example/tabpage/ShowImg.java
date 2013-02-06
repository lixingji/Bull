package com.example.tabpage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

	public class ShowImg extends Activity implements OnClickListener{

		Button btnGallery,btnImageSwitcher;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.showimage);
			
				btnGallery=(Button)this.findViewById(R.id.button1);//取得组件
				btnImageSwitcher=(Button)this.findViewById(R.id.button2);//取得组件
				btnGallery.setOnClickListener(this); // 按钮监听
				btnImageSwitcher.setOnClickListener(this);// 按钮监听
			}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.button1:// 点击Gallery按钮
				Intent intent1=new Intent(this,GalleryView.class);//新意图
				startActivity(intent1);
				break;
			case R.id.button2:// 点击ImageSwitcher按钮
				Intent intent2=new Intent(this,ImageSwitcherView.class);//新意图
				startActivity(intent2);
			    break;
			default:
				break;
			}
			
		}
	}