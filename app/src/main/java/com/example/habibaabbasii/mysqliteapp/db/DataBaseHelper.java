package com.example.habibaabbasii.mysqliteapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATA_BASE_TABLE="User.sq";
    public static final String TABLE_NAME="User_Data";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="Email";
    public static  final String COL_4="Password";


    public DataBaseHelper(Context context){
        super(context,DATA_BASE_TABLE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {

String createTable="CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+" NAME TEXT, EMAIL TEXT, PASSWORD TEXT)";
sq.execSQL(createTable);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sq, int oldVersion, int newVersion) {
        sq.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sq);
    }

   public Cursor getAllData(){
        SQLiteDatabase sq= this.getWritableDatabase();
        Cursor cursor =sq.rawQuery("SELECT * from "+TABLE_NAME,null);
        return cursor;

   }

//   public boolean onAddData( String name, String email, String password)
//   {
//       SQLiteDatabase sq=this.getWritableDatabase();
//       ContentValues cv=new ContentValues();
//       cv.put(COL_2,name); //key,value
//       cv.put(COL_3,email);
//       cv.put(COL_4,password);
//
//     long result = sq.insert(TABLE_NAME,null,cv);
//
//     //if data will insert incorrectly it will return -1
//     if(result == -1) {
//         return false;
//     }else {
//         return true;
//     }
//   }
public boolean addData(String name, String email, String password){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_2,name);
    contentValues.put(COL_3,email);
    contentValues.put(COL_4, password);

    long result  = db.insert(TABLE_NAME, null, contentValues);


    if(result == -1){
        return false;
    }else{
        return true;
    }
}

    public Integer onUpdateData( String id ,String name, String email, String password)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_1,id);
        cv.put(COL_2,name); //key,value
        cv.put(COL_3,email);
        cv.put(COL_4,password);

        //sq.update(TABLE_NAME,cv,"ID = ? ",new String[] {id});
        return sq.update(TABLE_NAME,cv,"ID = ? ",new String[] {id});
    }


   public Integer onDelete(String id){

       SQLiteDatabase sq=this.getWritableDatabase();

       return sq.delete(TABLE_NAME,"ID = ?",new String[] {id});

   }
}
