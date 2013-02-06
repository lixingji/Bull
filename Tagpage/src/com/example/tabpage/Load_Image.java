package com.example.tabpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Load_Image extends Activity implements OnClickListener{

		private Button butLoad;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.load_image);
			butLoad=(Button)this.findViewById(R.id.butLoad);
			butLoad.setOnClickListener(this);
			
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent3=new Intent(this,ShowLV.class);//–¬“‚Õº
			startActivity(intent3);
		}
	}

