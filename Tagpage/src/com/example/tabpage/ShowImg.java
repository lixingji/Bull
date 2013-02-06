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
			
				btnGallery=(Button)this.findViewById(R.id.button1);//ȡ�����
				btnImageSwitcher=(Button)this.findViewById(R.id.button2);//ȡ�����
				btnGallery.setOnClickListener(this); // ��ť����
				btnImageSwitcher.setOnClickListener(this);// ��ť����
			}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.button1:// ���Gallery��ť
				Intent intent1=new Intent(this,GalleryView.class);//����ͼ
				startActivity(intent1);
				break;
			case R.id.button2:// ���ImageSwitcher��ť
				Intent intent2=new Intent(this,ImageSwitcherView.class);//����ͼ
				startActivity(intent2);
			    break;
			default:
				break;
			}
			
		}
	}