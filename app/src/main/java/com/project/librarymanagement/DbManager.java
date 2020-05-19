package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper{

    private static final String DBNAME = "library.db";
    private static final String TABLENAME = "library_books";

    public DbManager(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLENAME+" (id integer primary key autoincrement, title text, description text, author text, price text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }

    public String addNewBookOnClick(String title, String description, String author, String price){ //we can change string with boolean if returning true or false
        //return "ok";
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("title",title);
        cv.put("description",description);
        cv.put("author",author);
        cv.put("price",price);

        long res = db.insert(TABLENAME, null,cv);

        if (res == -1)
            return "Failed";
        else
            return "Successfully inserted";
    }
    public Cursor getAllBooks(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+TABLENAME;
        //String query = "select * from users where username = 'bhawana'";

        Cursor crs = db.rawQuery(query,null);
        return crs;
    }
}
