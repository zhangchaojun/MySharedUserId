package com.example.mytest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(@Nullable Context context) {
        super(context, "mydatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String sqlCreate =   "create table Book (" +
                "id integer primary key autoincrement," +
                "author text," +
                "price real," +
                "pages integer," +
                "name text)";
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
