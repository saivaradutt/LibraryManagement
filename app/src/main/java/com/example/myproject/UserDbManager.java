package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myproject.Entity.LibraryPOJO;

import java.util.ArrayList;

public class UserDbManager extends SQLiteOpenHelper {
    private static final String DBNAME = "projectDb.db";
    private static final String USERTABLENAME = "users";

    public UserDbManager(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String userQuery = "create table " + USERTABLENAME + " (id integer primary key autoincrement, username text, password text, email text, dob text, status text)";
        db.execSQL(userQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USERTABLENAME);
        onCreate(db);
    }

    public String registerOnClick(String username, String password, String email, String dob) { //we can change string with boolean if returning true or false
        //return "ok";
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        cv.put("email", email);
        cv.put("dob", dob);
        cv.put("status", "user");

        long res = db.insert(USERTABLENAME, null, cv);

        if (res == -1)
            return "Failed";
        else
            return "Successfully Registered";
    }

    public Cursor searchData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from " + USERTABLENAME + " where username ='" + username + "' and password = '" + password + "'";
        //String query = "select * from users where username = 'bhawana'";

        Cursor crs = db.rawQuery(query, null);
        return crs;
    }
}
