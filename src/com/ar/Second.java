package com.ar;

import java.util.ArrayList;
import java.util.List;

import com.ar.ByCollege.DataBaseAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class Second extends Activity {
	
	private DataBaseAdapter adapter=null; 
	SQLiteDatabase myDataBase;
	 EditText edit;
RadioButton radiobutton;
RadioGroup radiogroup;

	Button button;
	Spinner spinner1;
	int selected;
	//DataBaseHelper mydatabaseHelper = new DataBaseHelper(this);
	private Cursor ourCursor=null;
    //Get Reference of your db
  //SQLiteDatabase myDataBase = mydatabaseHelper.openDataBase();		    
	private DataBaseHelper mydatabaseHelper = new DataBaseHelper(this);
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		addListenerOnButton();
		addItemsOnSpinner2();
		addListenerOnButton2();
		
	
		TextView t=(TextView)findViewById(R.id.txt);
		String str="\n"+"**OCB = OC BOY"+"\n"+"   SCG = SC GIRL"+"\n"+"   BCAB = BC_A-BOY"+"\n"+"   SO ON..";
	t.setText(str);
	
	
	}
	 public void addListenerOnButton() {
    	 
 		final Second context = this;
 		//this is for which button?
 		//cancel button
  
 		button = (Button) findViewById(R.id.button2);
  
 		button.setOnClickListener(new OnClickListener() {
  
 			
 			public void onClick(View arg0) {
  
 			    Intent intent = new Intent(context, mainpage.class);
                             startActivity(intent);   
  
 			}
  
 		});
  
 	}
	
	public void addItemsOnSpinner2() {
		 
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();
		list.add("OCB");
		list.add("OCG");
		list.add("SCB");
		list.add("SCG");
		list.add("STB");
		list.add("STG");
		list.add("BCAB");
		list.add("BCAG");
		list.add("BCBB");
		list.add("BCBG");
		list.add("BCCB");
		list.add("BCCG");
		list.add("BCDB");
		list.add("BCDG");
		list.add("BCEB");
		list.add("BCEG");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter);
	  }
	
	public void addListenerOnButton2() {
     	 
		final Second context = this;
		//this is for submit?yes
 
		button = (Button) findViewById(R.id.button1);
 
		button.setOnClickListener(new OnClickListener() {
 
			
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Submit2.class);
			   
			   
			    edit=(EditText) findViewById(R.id.editText1);
				   String spinnerv=spinner1.getSelectedItem().toString();
				String edittext=edit.getText().toString();				
				
				//TextView printt=(TextView)findViewById(R.id.print);
				  //printt.setText(edittext);
				
	String arr[]={edittext,spinnerv};
	
     
     //Get Reference of your db
    intent.putExtra("data", arr);			

			       startActivity(intent);   
 }
 
});
 } 

	class DataBaseAdapter extends CursorAdapter
	{
	DataBaseAdapter(Cursor c){
	super(Second.this,c);
	}
	public void bindView(View row,Context ctxt,Cursor c)
	{
	DataBaseHolder holder=(DataBaseHolder)row.getTag();
	holder.populateFrom(c,mydatabaseHelper);
	}
	public View newView(Context ctxt,Cursor c,ViewGroup parent)
	{
	LayoutInflater inflater=getLayoutInflater();
	View row=inflater.inflate(R.layout.main7,parent,false);
	DataBHolder holder=new DataBHolder(row);
	row.setTag(holder);
	return(row);
	}
	}
	}

	class DataBHolder
	{
	private TextView name=null;

	DataBHolder(View row)
	{
	name=(TextView)row.findViewById(R.id.textView1);
	
	
	}

	void populateFrom(Cursor c,DataBaseHelper r)
	{
		
			name.setText(r.getName(c));
			


	}

	

	}
	
