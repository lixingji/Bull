package com.example.tabpage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwitcherView extends Activity implements OnClickListener,
		ViewFactory {

	private ImageSwitcher imageSwitcher; // �������
	private Button Pre, Next; // ����Button������PreΪ��ǰ��NextΪ����ȡ��Ƭ
	private int index = 0; // ͼƬ���±�
	private List<Drawable> list = new ArrayList<Drawable>();// ����û���ͼƬ��Ϣ

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myimageswitcher);
		imageSwitcher = (ImageSwitcher) this.findViewById(R.id.imageSwitcher1);// ȡ�����
		Pre = (Button) this.findViewById(R.id.pre);// ȡ�����
		Next = (Button) this.findViewById(R.id.next);// ȡ�����
		Pre.setOnClickListener(this); // ��ť����
		Next.setOnClickListener(this);// ��ť����
		imageSwitcher.setFactory(this);
		// ��list��װ��ͼƬ
		list.add(getResources().getDrawable(R.drawable.img1));
		list.add(getResources().getDrawable(R.drawable.img2));
		list.add(getResources().getDrawable(R.drawable.img3));
		list.add(getResources().getDrawable(R.drawable.img4));
		list.add(getResources().getDrawable(R.drawable.img5));
		list.add(getResources().getDrawable(R.drawable.img6));
		list.add(getResources().getDrawable(R.drawable.img7));
		list.add(getResources().getDrawable(R.drawable.img8));
		list.add(getResources().getDrawable(R.drawable.img9));
		list.add(getResources().getDrawable(R.drawable.img10));
		list.add(getResources().getDrawable(R.drawable.img11));
		list.add(getResources().getDrawable(R.drawable.img12));
		list.add(getResources().getDrawable(R.drawable.img13));
		list.add(getResources().getDrawable(R.drawable.img14));
		list.add(getResources().getDrawable(R.drawable.img15));
		// ��ʼ������ͼƬ��Ϣ
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
		return new ImageView(ImageSwitcherView.this);// ����һ���µ�ͼƬ
	}

	@Override
	public void onClick(View v) {// �����ť��Ӧ
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.pre:// ���Pre��ť
			index--;
			if (index < 0) {
				index = list.size() - 1;
			}
			imageSwitcher.setImageDrawable(list.get(index)); // list�����±�Ϊindex��ͼƬ
			break;
		case R.id.next:// ���Next��ť
			index++;
			if (index >= list.size()) {
				index = 0;
			}
			imageSwitcher.setImageDrawable(list.get(index)); // list�����±�Ϊindex��ͼƬ
			break;
		default:
			break;
		}
	}

}
