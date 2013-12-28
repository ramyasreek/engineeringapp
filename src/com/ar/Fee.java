package com.ar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Fee extends Activity {
	 
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.feemain);
	        //addListenerOnButton();
		
	        
	        TextView txt=(TextView)findViewById(R.id.text);
	        String str="WHAT IS SEARCH BY RANK?" +
	        		"\n"+
	        		"Enter your eamcet rank and select your category then you will be shown the college names which you are tentatively eligible for."
	        		+ "\n" + "This is basically for your reference to know in which college you may get." +
	        	"\n \n \n"	+"WHAT IS SEARCH BY COLLEGE?" + "\n"
	        		+ "Type the partial or the full name or institute code.You will be shown the college names.Click on the college name to get the details."
	                ;
	        txt.setText(str);
	        
	        
		}
}