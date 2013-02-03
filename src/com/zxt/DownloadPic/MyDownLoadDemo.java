package com.zxt.DownloadPic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;


public class MyDownLoadDemo extends Activity {

	private static final String Path="http://www.mldnjava.cn/android/android_book.jpg";//ͼƬ������ַ
	private final String FileName="/mnt/sdcard/myData/logo.jpg";
	private Bitmap bitmap=null;//����λͼͼ��
	private ImageView imgShow=null;//����ͼƬ��ʾ�����ر�����ʾ��
	private ImageView imgLoad=null;//����ͼƬ��ʾ�����ض�ȡ��ʾ��
	private Button butSave=null;//���尴ť���
	private Button butLoad=null;//���尴ť���
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.butSave=(Button)super.findViewById(R.id.butSave);//ȡ�����
		this.butLoad=(Button)super.findViewById(R.id.butLoad);//ȡ�����
		this.imgShow=(ImageView)super.findViewById(R.id.imgShow);//ȡ�����
		this.imgLoad=(ImageView)super.findViewById(R.id.imgLoad);//ȡ�����
		this.butSave.setOnClickListener(new OnClickListenerSave());//���ü���
		this.butLoad.setOnClickListener(new OnClickListenerLoad());//���ü���
		
		try{
			this.bitmap=getUrlData(Path);
			this.imgShow.setImageBitmap(bitmap);//��ʾͼƬ
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Bitmap getUrlData(String path){
		String httpURL=path;
		Bitmap bitmap=null;
		//����Ĭ��ʵ����HttpClientʵ��,ȡ��HttpClient����
		HttpClient httpclient=new DefaultHttpClient();
		try{
			HttpGet httpResquest=new HttpGet(httpURL);//����httpResquest
			HttpResponse httpResponse=httpclient.execute(httpResquest);//����httClient��ȡ��HttpRsponse
			if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				//ȡ�������Ϣ��ȡ��HttpEntity
				HttpEntity httpEntity=httpResponse.getEntity();
				InputStream input=httpEntity.getContent();
				bitmap=BitmapFactory.decodeStream(input);
				input.close();
			}else{
				Toast.makeText(MyDownLoadDemo.this, "����ʧ��", Toast.LENGTH_LONG).show();
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return bitmap;
	}
	
		//���水ť�����¼�����
		private class OnClickListenerSave implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					//���ñ���ͼƬ����
					saveFile(MyDownLoadDemo.this.bitmap,MyDownLoadDemo.this.FileName);
					Toast.makeText(MyDownLoadDemo.this, "ͼƬ����ɹ���", Toast.LENGTH_LONG).show();
			}catch(IOException e){
				e.printStackTrace();
				Toast.makeText(MyDownLoadDemo.this, "ͼƬ����ʧ�ܣ�", Toast.LENGTH_LONG).show();
				}
			}
		}
		
		//���ض�ȡ��ť�����¼�
		private class OnClickListenerLoad implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File picFile=new File(MyDownLoadDemo.this.FileName);
				if(picFile.exists()){
					//ͼƬ����
					Bitmap bm=BitmapFactory.decodeFile(MyDownLoadDemo.this.FileName);
					MyDownLoadDemo.this.imgLoad.setImageBitmap(bm);
					Toast.makeText(MyDownLoadDemo.this, "ͼƬ�������", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(MyDownLoadDemo.this, "�ļ������ڣ�����ʧ�ܣ�", Toast.LENGTH_LONG).show();
				}
			}
			
		}
		
		//����ͼƬ
		public void saveFile(Bitmap bm,String fileName) throws IOException{
			File dirFile=new File(fileName);
			if(!dirFile.getParentFile().exists()){
				dirFile.getParentFile().mkdirs();
			}
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(dirFile));
			bm.compress(Bitmap.CompressFormat.JPEG, 80,bos);
		}
		
}
