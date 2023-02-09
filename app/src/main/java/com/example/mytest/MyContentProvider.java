package com.example.mytest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.mytest.db.MyOpenHelper;

public class MyContentProvider extends ContentProvider {


    private static final String TAG = "cj";
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final String authority = "com.example.myshareduserid.provider";
    private static final String PEOPLE = "PEOPLE";

    static {
        sURIMatcher.addURI(authority, PEOPLE, 1);
    }

    private MyOpenHelper myOpenHelper;


    public MyContentProvider() {
    }


    @Override
    public boolean onCreate() {
        myOpenHelper = new MyOpenHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.e(TAG, "收到请求: " );
       return myOpenHelper.getWritableDatabase().query("Book",null,null,null,null,null,null);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}