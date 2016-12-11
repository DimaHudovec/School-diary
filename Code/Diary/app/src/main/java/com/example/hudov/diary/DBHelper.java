package com.example.hudov.diary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "subjectDb";
    public static final String TABLE_NAME =  "subjTable";

    public static final String  KEY_ID =  "_id";
    public static final String  KEY_NUM =  "number";
    public static final String KEY_DATA =  "data";
    public static final String KEY_SUBJECT =  "subj";


    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" +
                KEY_ID + " integer primary key," +
                KEY_DATA + " text," +
                KEY_NUM + " text," +
                KEY_SUBJECT + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }
}
