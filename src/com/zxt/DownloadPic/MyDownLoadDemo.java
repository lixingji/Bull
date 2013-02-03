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

	private static final String Path="http://www.mldnjava.cn/android/android_book.jpg";//图片下载网址
	private final String FileName="/mnt/sdcard/myData/logo.jpg";
	private Bitmap bitmap=null;//定义位图图像
	private ImageView imgShow=null;//定义图片显示（下载保存显示）
	private ImageView imgLoad=null;//定义图片显示（加载读取显示）
	private Button butSave=null;//定义按钮组件
	private Button butLoad=null;//定义按钮组件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.butSave=(Button)super.findViewById(R.id.butSave);//取得组件
		this.butLoad=(Button)super.findViewById(R.id.butLoad);//取得组件
		this.imgShow=(ImageView)super.findViewById(R.id.imgShow);//取得组件
		this.imgLoad=(ImageView)super.findViewById(R.id.imgLoad);//取得组件
		this.butSave.setOnClickListener(new OnClickListenerSave());//设置监听
		this.butLoad.setOnClickListener(new OnClickListenerLoad());//设置监听
		
		try{
			this.bitmap=getUrlData(Path);
			this.imgShow.setImageBitmap(bitmap);//显示图片
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Bitmap getUrlData(String path){
		String httpURL=path;
		Bitmap bitmap=null;
		//创建默认实例，HttpClient实例,取得HttpClient对象
		HttpClient httpclient=new DefaultHttpClient();
		try{
			HttpGet httpResquest=new HttpGet(httpURL);//创建httpResquest
			HttpResponse httpResponse=httpclient.execute(httpResquest);//请求httClient，取得HttpRsponse
			if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				//取得相关信息，取得HttpEntity
				HttpEntity httpEntity=httpResponse.getEntity();
				InputStream input=httpEntity.getContent();
				bitmap=BitmapFactory.decodeStream(input);
				input.close();
			}else{
				Toast.makeText(MyDownLoadDemo.this, "链接失败", Toast.LENGTH_LONG).show();
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return bitmap;
	}
	
		//保存按钮单击事件监听
		private class OnClickListenerSave implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					//调用保存图片方法
					saveFile(MyDownLoadDemo.this.bitmap,MyDownLoadDemo.this.FileName);
					Toast.makeText(MyDownLoadDemo.this, "图片保存成功！", Toast.LENGTH_LONG).show();
			}catch(IOException e){
				e.printStackTrace();
				Toast.makeText(MyDownLoadDemo.this, "图片保存失败！", Toast.LENGTH_LONG).show();
				}
			}
		}
		
		//加载读取按钮单击事件
		private class OnClickListenerLoad implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File picFile=new File(MyDownLoadDemo.this.FileName);
				if(picFile.exists()){
					//图片存在
					Bitmap bm=BitmapFactory.decodeFile(MyDownLoadDemo.this.FileName);
					MyDownLoadDemo.this.imgLoad.setImageBitmap(bm);
					Toast.makeText(MyDownLoadDemo.this, "图片加载完成", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(MyDownLoadDemo.this, "文件不存在！加载失败！", Toast.LENGTH_LONG).show();
				}
			}
			
		}
		
		//保存图片
		public void saveFile(Bitmap bm,String fileName) throws IOException{
			File dirFile=new File(fileName);
			if(!dirFile.getParentFile().exists()){
				dirFile.getParentFile().mkdirs();
			}
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(dirFile));
			bm.compress(Bitmap.CompressFormat.JPEG, 80,bos);
		}
		
}
