package com.upgrad.worldcupscorecard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "worldcup";
    public static final String TABLE_NAME = "batsmanscorecard";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "RUNS";


    //constructor
    public DataBaseHelper(Context context) {
        //creating a database here
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      //create a table
        //create table bastmanscorecard (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,RUNS INTEGER);
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,RUNS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    /*
        CRUD
        Stand
        C is Create
        R is Read
        U is Update
        D is Delete
     */

    //reading a value from database
    public Cursor getAllValues ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME,null);
        return  result;
    }

    //insert data in database

    public boolean insertData(String name,String surname, String runs)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_2,name);
        values.put(COL_3,surname);
        values.put(COL_4,runs);
        long  result = db.insert(TABLE_NAME,null,values);
        if (result == -1){
            return false;
        }
        return true;
    }

    //update values in database

    public boolean updateData(String id,String name,String surname,String runs)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_1,id);
        values.put(COL_2,name);
        values.put(COL_3,surname);
        values.put(COL_4,runs);

        db.update(TABLE_NAME,values,"ID = ?",new String[]{id});
        return true;
    }


    //delete from database

    public Integer deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME,"ID = ?",new String[]{id});

    }


}
