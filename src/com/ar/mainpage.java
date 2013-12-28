package com.ar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mainpage extends Activity {
    /** Called when the activity is first created. */
	Button button;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 TextView tv=(TextView)findViewById(R.id.text);
 tv.setSelected(true);

        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
	}
        public void addListenerOnButton1() {
        	 
    		final mainpage context = this;
     
    		button = (Button) findViewById(R.id.button1);
     
    		button.setOnClickListener(new OnClickListener() {
     
    			
    			public void onClick(View arg0) {
     
    			    Intent intent = new Intent(context, Second.class);
                                startActivity(intent);   
     }
     
    });
     
  }
        public void addListenerOnButton2() {
       	 
    		final mainpage context = this;
     
    		button = (Button) findViewById(R.id.button2);
     
    		button.setOnClickListener(new OnClickListener() {
     
    			
    			public void onClick(View arg0) {
     
    			    Intent intent = new Intent(context, ByCollege.class);
                                startActivity(intent);   
     }
     
    });
     
  } 
        public void addListenerOnButton3() {
       	 
    		final mainpage context = this;
     
    		button = (Button) findViewById(R.id.button3);
     
    		button.setOnClickListener(new OnClickListener() {
     
    			
    			public void onClick(View arg0) {
     
    			    Intent intent = new Intent(context, Fee.class);
                                startActivity(intent);   
     }
     
    });
     
  }
        
        
        
	}
