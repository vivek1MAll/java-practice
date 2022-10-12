package com.example.draganddrop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Contact";
    private static final int DATABASE_ID=1;
    private static final String Table_contact="contacts";
    private static final String ID ="id";
    private static final String name ="name";
    private static final String phone ="phone";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_ID);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE "+ Table_contact + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + name +" TEXT,"+ phone +" TEXT " + " )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + Table_contact);
        onCreate(sqLiteDatabase);

    }
    public void addContact(String name,String phone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(name,name);
        values.put(phone,phone);

        db.insert(Table_contact,null,values);

    }
}
