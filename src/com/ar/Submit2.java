package com.ar;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Submit2 extends Activity {
	public final static String ID_EXTRA="com.ar._id";
	private DataBaseHelper mydatabaseHelper=null;
	private Cursor ourCursor=null;
	private DaAdapter adapter=null; 

	String[] str;
	String edit,spin;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submitbutton);
		
	str=getIntent().getStringArrayExtra("data");
	ListView myListView=(ListView)findViewById(R.id.list);
	mydatabaseHelper = new DataBaseHelper(this.getApplicationContext());
	ourCursor=mydatabaseHelper.getinforank(str);
	startManagingCursor(ourCursor);
	
	
	adapter=new DaAdapter(ourCursor);
    myListView.setAdapter(adapter);
    myListView.setOnItemClickListener(new OnItemClickListener() {

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
	class DaAdapter extends CursorAdapter
	{
	DaAdapter(Cursor c){
	super(Submit2.this,c);
	}
	public void bindView(View row,Context ctxt,Cursor c)
	{
	DaHolder holder=(DaHolder)row.getTag();
	holder.populateFrom(c,mydatabaseHelper);
	}
	public View newView(Context ctxt,Cursor c,ViewGroup parent)
	{
	LayoutInflater inflater=getLayoutInflater();
	View row=inflater.inflate(R.layout.main7,parent,false);
	DaHolder holder=new DaHolder(row);
	row.setTag(holder);
	return(row);
	}
	}


	class DaHolder
	{
	//private TextView name=null;
	private TextView a;
	DaHolder(View row)
	{
	//name=(TextView)row.findViewById(R.id.textView1);
	a=(TextView)row.findViewById(R.id.textView2);
	
	}
	void populateFrom(Cursor c,DataBaseHelper r)
	{
	//name.setText(r.getName(c));
	a.setText(r.getNamebutton(c));

		}
	}
	}



