package com.example.tabpage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryView extends Activity {

	private Gallery gallery; // 定义Gallery变量
	// 声明图片的数组
	private int[] resIds = { R.drawable.img1, R.drawable.img2, R.drawable.img3,
			R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7,
			R.drawable.img8, R.drawable.img9, R.drawable.img10,
			R.drawable.img11, R.drawable.img12, R.drawable.img13,
			R.drawable.img14, R.drawable.img15 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mygallery);

		gallery = (Gallery) this.findViewById(R.id.mygallery);// 取得组件
		ImageAdapter imageAdapter = new ImageAdapter(this);// new一个ImageAdapter
		gallery.setAdapter(imageAdapter);// 适配器设置
	}

	public class ImageAdapter extends BaseAdapter {

		private Context context;
		int mGalleryItemBackground;// 使用简单的计数器，填充背景图片

		public ImageAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub

			return Integer.MAX_VALUE;// 最大计数
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			if (position >= getCount())
				position = 0;
			return position;// 返回当前图像位置
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return resIds[position];// 返回数组对应的image
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			// 自定义的适配器
			ImageView imageView = new ImageView(context);// 新建imageView对象
			imageView.setImageResource(resIds[position]);// 图片资源
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);// 控制图片塞满view
			imageView.setLayoutParams(new Gallery.LayoutParams(500, 400));// 设置图像长宽参数
			imageView.setBackgroundResource(mGalleryItemBackground);// 取得背景
			return imageView;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
