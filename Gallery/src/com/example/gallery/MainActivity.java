package com.example.gallery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Gallery gallery; //����Gallery����
	//����ͼƬ������
	private int[] resIds={
		R.drawable.img1,R.drawable.img2,
		R.drawable.img3,R.drawable.img4,
		R.drawable.img5,R.drawable.img6,
		R.drawable.img7,R.drawable.img8,
		R.drawable.img9,R.drawable.img10,
		R.drawable.img11,R.drawable.img12,	
		R.drawable.img13,R.drawable.img14,
		R.drawable.img15
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		gallery=(Gallery)this.findViewById(R.id.gallery);
		ImageAdapter imageAdapter = new ImageAdapter(this);//
		gallery.setAdapter(imageAdapter);//����������
	}

	public class ImageAdapter extends BaseAdapter{

		private Context context;
		int mGalleryItemBackground;//ʹ�ü򵥵ļ���������䱳��ͼƬ
		public ImageAdapter(Context context){
			this.context=context;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			
			return Integer.MAX_VALUE;//������
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			if(position>=getCount())
			position=0;
			return position;//���ص�ǰͼ��λ��
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return resIds[position];//���������Ӧ��image
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			//�Զ���������������Զ���Ĳ�������ʾ
			ImageView imageView=new ImageView(context);//�½�imageView����
			imageView.setImageResource(resIds[position]);//ͼƬ��Դ
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);//����ͼƬ����view
			imageView.setLayoutParams(new Gallery.LayoutParams(500,400));//����ͼ�񳤿����
			imageView.setBackgroundResource(mGalleryItemBackground);
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
