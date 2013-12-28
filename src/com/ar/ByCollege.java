package com.ar;






import java.util.ArrayList;
import java.util.Queue;

import com.ar.DataBaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ByCollege extends Activity 
{
	
private DataBaseHelper mydatabaseHelper=null;
ArrayAdapter<String> adapter1;
private ArrayList<String> results = new ArrayList<String>();
private Cursor ourCursor=null;
private Cursor secCursor=null;
private DataBaseAdapter adapter=null; 
SQLiteDatabase myDataBase;
public final static String ID_EXTRA="com.ar._id";
String[] firstname;
EditText inputSearch;
Button button;
//public final static String ID1_EXTRA="com.ar.INSTCODE";
  
@Override
    public void onCreate(Bundle savedInstanceState) {
try
{       
      super.onCreate(savedInstanceState);
        setContentView(R.layout.mainbycollege);
        //auto=(AutoCompleteTextView)findViewById(auto);
        ListView lv=(ListView)findViewById(R.id.list_view);
                     
    
            
  
   button=(Button)findViewById(R.id.but);
//This methos will be used to copy db if doesn't exsist
        mydatabaseHelper = new DataBaseHelper(this);
        
        //Get Reference of your db
       myDataBase = mydatabaseHelper.openDataBase();
       inputSearch = (EditText) findViewById(R.id.edit);
     ourCursor=mydatabaseHelper.getCursor();       
      // startManagingCursor(ourCursor);
    //adapter=new DataBaseAdapter(ourCursor);
   //lv.setAdapter(adapter);
   
 	
      addListenerOnButton1();
   
lv.setOnItemClickListener(new OnItemClickListener() {

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	{
	
	// TODO Auto-generated method stub
	Intent i = new Intent(getApplicationContext(), SingleListItem.class);
	
	
	i.putExtra(ID_EXTRA,String.valueOf(id));
	//i.putExtra(
	
    startActivity(i);
	
	
	}
});



}
catch(Exception e)
{
Log.e("ERROR","ERROR IN CODE:"+e.toString());
e.printStackTrace();
}
}

public void addListenerOnButton1() {
	 
	final ByCollege context = this;

	button = (Button) findViewById(R.id.but);

	button.setOnClickListener(new OnClickListener() {

		
		public void onClick(View arg0) {
			 ListView lv=(ListView)findViewById(R.id.list_view); 
			inputSearch = (EditText) findViewById(R.id.edit);
			//lv.setBackgroundColor(R.drawable.cc);
			 String txt=inputSearch.getText().toString();
			//Log.w("testing",txt);
		 secCursor=mydatabaseHelper.getinfo2(txt);
			//Log.w("Test1", secCursor.getColumnNames().toString());
			 //for (String column : secCursor.getColumnNames()) {
				//	Log.w("Test1", column);
				//}
			 
			 startManagingCursor(secCursor);
			    adapter=new DataBaseAdapter(secCursor);
			   
			    lv.setAdapter(adapter);
		}});

	
}


class DataBaseAdapter extends CursorAdapter
{
DataBaseAdapter(Cursor c){
super(ByCollege.this,c);
}
public void bindView(View row,Context ctxt,Cursor c)
{
DataBaseHolder holder=(DataBaseHolder)row.getTag();
holder.populateFrom(c,mydatabaseHelper);
}
public View newView(Context ctxt,Cursor c,ViewGroup parent)
{
LayoutInflater inflater=getLayoutInflater();
View row=inflater.inflate(R.layout.main3,parent,false);
DataBaseHolder holder=new DataBaseHolder(row);
row.setTag(holder);
return(row);
}
}
}

class DataBaseHolder
{
private TextView name=null;

DataBaseHolder(View row)
{
name=(TextView)row.findViewById(R.id.textView1);

}

void populateFrom(Cursor c,DataBaseHelper r)
{
		name.setText(r.getNamebutton(c));
		


}

}








/*

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ByCollege extends ListActivity {
	
	private ArrayList<String> results = new ArrayList<String>();
	private String tableName = DataBaseHelper.TABLE_NAME;
	private SQLiteDatabase newDB;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        openAndQueryDatabase();
        
        displayResultList();
        
        
    }
	private void displayResultList() {
		TextView tView = new TextView(this);
  //      tView.setText("This data is retrieved from the database and only 4 " +
    //    		"of the results are displayed");
        getListView().addHeaderView(tView);
        
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
		
	}
	private void openAndQueryDatabase() {
		try {
			DataBaseHelper dbHelper = new DataBaseHelper(this.getApplicationContext());
			newDB = dbHelper.getWritableDatabase();
			Cursor c = newDB.rawQuery("SELECT NAMEOFTHECOLLEGE FROM " +
					DataBaseHelper.TABLE_NAME , null);

	    	if (c != null ) {
	    		if  (c.moveToFirst()) {
	    			do {
	    				String firstName = c.getString(c.getColumnIndex("NAMEOFTHECOLLEGE"));
	    				//int age = c.getInt(c.getColumnIndex("Age"));
	    				//results.add(firstName);// + ",Age: " + age);
	    				  
	    TextView helloName = (TextView)findViewById(R.id.textView1);
	         helloName.setText(firstName);
	                	  break;
	    			}while (c.moveToNext());
	    		} 
	    	}			
		} catch (SQLiteException se ) {
        	Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } finally {
        	if (newDB != null) 
        		newDB.execSQL("DELETE FROM " + tableName);
        		newDB.close();
                    }

}
	
}







*/