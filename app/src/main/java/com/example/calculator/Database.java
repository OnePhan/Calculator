package com.example.calculator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
//  Query
    public void QueryData(String url){
        SQLiteDatabase database = getWritableDatabase();
        database. execSQL(url);
    }
//  Getdata
    public Cursor getData(String url){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(url, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
