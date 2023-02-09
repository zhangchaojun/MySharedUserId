package com.example.resolver;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "cj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.example.myshareduserid.provider/PEOPLE");
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if(cursor!=null){
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.e(TAG, "获取到名字: " + name);
            }

        }else{
            Log.e(TAG, "cursor == null" );
        }

    }
}