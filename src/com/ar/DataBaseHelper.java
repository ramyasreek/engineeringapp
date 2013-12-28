package com.ar;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Debug;
import android.util.Log;


 public class DataBaseHelper extends SQLiteOpenHelper{
 
    //The Android's default system path of your application database.
	//replace com.binarybricks.shippingwithsqllite with you Application package nae
	//This should be same as which you used package section in your manifest
    private static String DB_PATH = "/data/data/com.ar/databases/";
 
    //replace this with name of your db file which you copied into asset folder
    private static String DB_NAME = "clgdata.db";
  //  private static final int SCHEMA_VERSION=1;
public static final String TABLE2_NAME="clgdata";
 static final String COLUMN_ID="_id";
 static final String COLUMN_TITLE="NAMEOFTHECOLLEGE";
 static final String COLUMN_TITLE1="CRSCODE";
 static final String COLUMN_TITLE2="INSTCODE";
 static final String COLUMN_TITLE3="PLACE";
 static final String COLUMN_TITLE4="NAMEOFTHECOURSE";
 
 public static final String TABLE_NAME="onlycollege";
 static final String COLUMN2_TITLE="CRSCODE";
 static final String COLUMN1_TITLE="NAMEOFTHECOLLEGE";
 static final String COLUMN_ID1="_id";
 static final String COLUMN4_TITLE="NAMEOFTHECOURSE"; 
 
private SQLiteDatabase myDataBase; 

    private final Context myContext;
 
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context) {
 
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
        this.createDataBase();
       
        
    }	
    
  /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase(){
    	try {
    	boolean dbExist = checkDataBase();
 
    	if(dbExist){
    		this.getReadableDatabase();
        	
    		 
			copyDataBase();
//do nothing - database already exist
    	}else{
    		//By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
        	this.getReadableDatabase();
        	
 
    			copyDataBase();
 
    		}
    	}
    	catch (Exception e) {

        	}
    }
 
    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){
 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    		checkDB.setLocale(Locale.getDefault());
    		checkDB.setLockingEnabled(true);
    		checkDB.setVersion(1);
    	}catch(SQLiteException e){
 
    		//database does't exist yet.
    		
    	}
 
    	if(checkDB != null){
 
    		checkDB.close();
 
    	}
 
    	return checkDB != null ? true : false;
    }
 
    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase(){
 
    	try{
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
    	}
    	catch (Exception e) {
			//catch exception
		}
    }
 
    public SQLiteDatabase openDataBase() throws SQLException{
 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    	return myDataBase;
 
    }
 
    
	public synchronized void close() {
 
    	    if(myDataBase != null)
    	    { myDataBase.close();}
 
    	    super.close();
 
	}
 
	
	public void onCreate(SQLiteDatabase db) {
 
	}
 
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
	
public Cursor getCursor()
{

SQLiteQueryBuilder queryBuilder=new SQLiteQueryBuilder();
queryBuilder.setTables(TABLE2_NAME);

String[] asColumnToReturn=new String[] {"_id","INSTCODE","CRSCODE","NAMEOFTHECOLLEGE","TYPE","REG","DIST","OCB","OCG"};
Cursor mCursor=queryBuilder.query(myDataBase,asColumnToReturn,null,null,null,null,"NAMEOFTHECOLLEGE");


return mCursor; 
}
public String getNamebutton(Cursor c)
{
	return(c.getString(2)+"-"+c.getString(8));
	}





public String getName(Cursor c)
{
	return(c.getString(3)+"-"+c.getString(2));
	}

public String getName1(Cursor c)
{
	return("INSTCODE: "+c.getString(1));
	}

public String getName2(Cursor c)
{
	return("DISTRICT: "+c.getString(5));
	}

public String getName3(Cursor c)
{
	return("PLACE: "+c.getString(6));
}
public String getcrc(Cursor c)
{
	return("COURSE: "+c.getString(8));
}
public String getName4(Cursor c)
{return("OC-BOY: "+c.getString(10));}
public String getName5(Cursor c)
{return("OC-GIRL: "+c.getString(11));}
public String getName6(Cursor c)
{return("SC-BOY: "+c.getString(12));}
public String getName7(Cursor c)
{return("SC-GIRL: "+c.getString(13));}
public String getName8(Cursor c)
{return("ST-BOY: "+c.getString(14));}
public String getName9(Cursor c)
{return("ST-GIRL: "+c.getString(15));}
public String getName10(Cursor c)
{return("BC_A-BOY: "+c.getString(14));}
public String getName11(Cursor c)
{return("BC_A-GIRL: "+c.getString(15));}
public String getName12(Cursor c)
{return("BC_B-BOY: "+c.getString(14));}
public String getName13(Cursor c)
{return("BC_B-GIRL: "+c.getString(15));}
public String getName14(Cursor c)
{return("BC_C-BOY: "+c.getString(14));}
public String getName15(Cursor c)
{return("BC_C-GIRL: "+c.getString(15));}
public String getName16(Cursor c)
{return("BC_D-BOY: "+c.getString(16));}
public String getName17(Cursor c)
{return("BC_D-GIRL: "+c.getString(17));}
public String getName18(Cursor c)
{return("BC_E-BOY: "+c.getString(18));}
public String getName19(Cursor c)
{return("BC_E-GIRL: "+c.getString(19));}

public String getName90(Cursor c)
{return(c.getString(19));}


public Cursor getinfo(String id){
	String[] args={id};
	
Cursor cursor=getReadableDatabase().rawQuery("select * from clgdata where _id=?",args);
//for (String column : cursor.getColumnNames()) {
	//Log.w("Test1", column);
//}
//Log.w("Test1", cursor.getColumnNames().toString());
//wait a sec, I'll see why the breakpoints aren't being hit
	return cursor;
}
public Cursor getinfo2(String str){
	Log.w("str", str);
	String[] args={"%'"+str+"'%"};
	
Cursor cursor=getReadableDatabase().rawQuery("select * from clgdata where NAMEOFTHECOLLEGE like '"+str+"%' or INSTCODE like '"+str+"%'" ,null);
//for (String column : cursor.getColumnNames()) {
	//Log.w("Test1", column);
//}
//Log.w("Test1", cursor.getColumnNames().toString());
//wait a sec, I'll see why the breakpoints aren't being hit
	return cursor;
}

public Cursor getinforank(String[] str) {
	// TODO Auto-generated method stub
	//Long a=0;
	//String c=str[1];
	int car=Integer.parseInt(str[0]);
	String spin=str[1];
	Cursor cursor=getReadableDatabase().rawQuery("select * from clgdata where "+spin+">="+car,null);
	//for (String column : cursor.getColumnNames()) {
	//Log.w("Test1", column);
//}
	
	
	
	return cursor;


}


}























