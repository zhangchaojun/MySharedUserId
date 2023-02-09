package com.example.mytest;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cj.library.base.BaseActivity;
import com.example.myshareduserid.R;
import com.example.mytest.db.MyOpenHelper;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "cj";
    private SQLiteDatabase database;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        MyOpenHelper openHelper = new MyOpenHelper(this);
        database = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("author","chaojun");
        contentValues.put("price",13.5);
        contentValues.put("pages",105);
        contentValues.put("name","gangtieshizenyanglianchengde");
        long book = database.insert("Book", null, contentValues);
        Log.e(TAG, "initView: "+book );

    }


    @SuppressLint("Range")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:

                try {
                    String shareId = getPackageManager().getPackageInfo(getPackageName(), 0).sharedUserId;
                    Toast.makeText(this, "sharedUserId为："+shareId, Toast.LENGTH_SHORT).show();
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException(e);
                }

                Cursor cursor = database.query("Book", null, null, null, null, null, null);
                while(cursor.moveToNext()){
                  String name = cursor.getString(cursor.getColumnIndex("name"));
                    Log.e(TAG, "onClick: "+name );
                }


                break;
        }
    }


}
