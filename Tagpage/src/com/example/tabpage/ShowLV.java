package com.example.tabpage;

import android.os.Bundle;
import java.io.File;  
import java.util.ArrayList;  
import java.util.HashMap;  
import android.app.Activity;  
import android.os.Environment;  
import android.util.Log;  
import android.widget.ListView;  
import android.widget.SimpleAdapter;  
  
public class ShowLV extends Activity {  
    private ListView lv;  
    ArrayList name;  
  
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.showlsv);  
        lv = (ListView) findViewById(R.id.list_view);  
        name = new ArrayList();  

        if (Environment.getExternalStorageState().equals(  
                Environment.MEDIA_MOUNTED)) {  
           // File path = Environment.getExternalStorageDirectory();// ���SD��·��   
            File path = new File("/mnt/sdcard/myData/");   
            File[] files = path.listFiles();// ��ȡ   
            getFileName(files);  
        }  
        SimpleAdapter adapter = new SimpleAdapter(this, name, R.layout.sd_list,  
                new String[] {"Name" , "img_pre"}, new int[] {R.id.txt_tv,R.id.img_pre });  
        lv.setAdapter(adapter);  
        for (int i = 0; i < name.size(); i++) {  
            Log.i("zeng", "list.  name:  " + name.get(i));  
        }  
    }  
  
    private void getFileName(File[] files) {  
        if (files != null) {// ���ж�Ŀ¼�Ƿ�Ϊ�գ�����ᱨ��ָ��   
            for (File file : files) {  
                if (file.isDirectory()) {  
                    Log.i("zeng", "�����ļ�Ŀ¼��������1" + file.getName().toString()  
                            + file.getPath().toString());  
  
                    getFileName(file.listFiles());  
                    Log.i("zeng", "�����ļ�Ŀ¼��������2" + file.getName().toString()  
                            + file.getPath().toString());  
                } else {  
                    String fileName = file.getName();  
                    if (fileName.endsWith(".jpg")) {  
                        HashMap map = new HashMap();  
                        String s = fileName.substring(0,  
                                fileName.lastIndexOf(".")).toString();  
                        Log.i("zeng", "�ļ���txt����   " + s);  
                        map.put("img_pre", R.drawable.baidu);
                        map.put("Name", fileName.substring(0,  
                                fileName.lastIndexOf(".")));  
                        
                        name.add(map);  
                    }  
                }  
            }  
        }  
    }  
}  

