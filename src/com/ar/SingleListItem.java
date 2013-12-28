package com.ar;

//import com.ar.ByCollege.DataBaseAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SingleListItem extends Activity{
	
	String passedVar=null;
	
	private TextView passedView=null;
	private DataBaseHelper mydatabaseHelper=null;
	private Cursor ourCursor=null;
	private DataAdapter adapter=null; 

	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submain2);
	passedVar=getIntent().getStringExtra(ByCollege.ID_EXTRA);
	
	ListView myListView=(ListView)findViewById(R.id.list);
		
	mydatabaseHelper = new DataBaseHelper(this.getApplicationContext());
	ourCursor=mydatabaseHelper.getinfo(passedVar);
	
	startManagingCursor(ourCursor);
	
	adapter=new DataAdapter(ourCursor);
    myListView.setAdapter(adapter);
      //passedView=(TextView)findViewById(R.id.product_label);
	    //passedView.setText(" IS  "+passedVar);
	


}
class DataAdapter extends CursorAdapter
{
DataAdapter(Cursor c){
super(SingleListItem.this,c);
}
public void bindView(View row,Context ctxt,Cursor c)
{
DataHolder holder=(DataHolder)row.getTag();
holder.populateFrom(c,mydatabaseHelper);
}
public View newView(Context ctxt,Cursor c,ViewGroup parent)
{
LayoutInflater inflater=getLayoutInflater();
View row=inflater.inflate(R.layout.row,parent,false);
DataHolder holder=new DataHolder(row);
row.setTag(holder);
return(row);
}
}


class DataHolder
{
//private TextView name=null;
private TextView a,b,ca,d,e,f,g,h,i,j,k,l,m,n,o,p,q,rs,t,x;
DataHolder(View row)
{
//name=(TextView)row.findViewById(R.id.textView1);
a=(TextView)row.findViewById(R.id.textView2);
b=(TextView)row.findViewById(R.id.textView4);
ca=(TextView)row.findViewById(R.id.textView3);
x=(TextView)row.findViewById(R.id.textView70);
d=(TextView)row.findViewById(R.id.textView5);
e=(TextView)row.findViewById(R.id.textView6);
f=(TextView)row.findViewById(R.id.textView7);
g=(TextView)row.findViewById(R.id.textView8);
h=(TextView)row.findViewById(R.id.textView9);
i=(TextView)row.findViewById(R.id.textView10);
j=(TextView)row.findViewById(R.id.textView11);
k=(TextView)row.findViewById(R.id.textView12);
l=(TextView)row.findViewById(R.id.textView13);
m=(TextView)row.findViewById(R.id.textView14);
n=(TextView)row.findViewById(R.id.textView15);
o=(TextView)row.findViewById(R.id.textView16);
p=(TextView)row.findViewById(R.id.textView17);
q=(TextView)row.findViewById(R.id.textView18);
rs=(TextView)row.findViewById(R.id.textView19);
t=(TextView)row.findViewById(R.id.textView20);

}
void populateFrom(Cursor c,DataBaseHelper r)
{
//name.setText(r.getName(c));
a.setText(r.getName1(c));

b.setText(r.getName2(c));
ca.setText(r.getName3(c));
x.setText(r.getcrc(c));
d.setText(r.getName4(c));
e.setText(r.getName5(c));
f.setText(r.getName6(c));
g.setText(r.getName7(c));
h.setText(r.getName8(c));
i.setText(r.getName9(c));
j.setText(r.getName10(c));

k.setText(r.getName11(c));
l.setText(r.getName12(c));
m.setText(r.getName13(c));
n.setText(r.getName14(c));
o.setText(r.getName15(c));
p.setText(r.getName16(c));
q.setText(r.getName17(c));
rs.setText(r.getName18(c));
t.setText(r.getName19(c));
}
}
}
