package com.example.myimageview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity implements OnClickListener,
		ViewFactory {

	private ImageSwitcher imageSwitcher; // 定义变量
	private Button Pre, Next; // 定义Button变量，Pre为向前，Next为向后获取照片
	private int index = 0; // 图片的下标
	private List<Drawable> list = new ArrayList<Drawable>();// 存放用户的图片信息

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageSwitcher = (ImageSwitcher) this.findViewById(R.id.imageSwitcher1);
		Pre = (Button) this.findViewById(R.id.button1);
		Next = (Button) this.findViewById(R.id.button2);
		Pre.setOnClickListener(this); // 按钮监听
		Next.setOnClickListener(this);// 按钮监听
		imageSwitcher.setFactory(this);
		// 往list中装载图片
		list.add(getResources().getDrawable(R.drawable.img1));
		list.add(getResources().getDrawable(R.drawable.img2));
		list.add(getResources().getDrawable(R.drawable.img3));
		list.add(getResources().getDrawable(R.drawable.img4));
		list.add(getResources().getDrawable(R.drawable.img5));
		list.add(getResources().getDrawable(R.drawable.img6));
		// 初始化加载图片信息
		if (list.size() > 0) {
			imageSwitcher.setImageDrawable(list.get(0));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		return new ImageView(MainActivity.this);// 返回一张新的图片
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:// 点击Pre按钮
			index--;
			if (index < 0) {
				index = list.size() - 1;
			}
			imageSwitcher.setImageDrawable(list.get(index)); // list加载下标为index的图片
			break;
		case R.id.button2:// 点击Next按钮
			index++;
			if (index >= list.size()) {
				index = 0;
			}
			imageSwitcher.setImageDrawable(list.get(index)); // list加载下标为index的图片
			break;
		default:
			break;
		}
	}

}
