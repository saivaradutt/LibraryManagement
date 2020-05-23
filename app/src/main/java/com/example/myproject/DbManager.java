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

public class DbManager extends SQLiteOpenHelper {
    private static final String DBNAME = "library.db";
    private static final String USERTABLENAME = "users";
    private static final String TABLENAME = "library_books";

    public DbManager(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String productQuery = "create table "+TABLENAME+" (id integer primary key autoincrement, title text, description text, author text, price text, ImagePath text)";
        String userQuery = "create table "+USERTABLENAME+" (id integer primary key autoincrement, username text, password text, email text, dob text, status text)";
        db.execSQL(productQuery);
        db.execSQL(userQuery);

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
    public ArrayList<LibraryPOJO> getAllBooks(){

        ArrayList<LibraryPOJO> libraryPOJOS = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select id, title, description, author, price from "+TABLENAME;
        //String query = "select * from users where username = 'bhawana'";

        Cursor cursor = db.rawQuery(query,null);

        if (cursor != null) {
            cursor.moveToFirst();

            while (cursor.isAfterLast()==false){

                cursor.getString(cursor.getColumnIndex("title"));

                int Id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String str_des = cursor.getString(cursor.getColumnIndex("description"));
                String auth = cursor.getString(cursor.getColumnIndex("author"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                //String image = cursor.getString(cursor.getColumnIndex("ImagePath"));

                double price1 = Double.parseDouble(price);

                libraryPOJOS.add(new LibraryPOJO(Id, title, str_des, auth, price1));

                Log.e("value", title);
                //System.out.println("Values" + title);

                cursor.moveToNext();

            }
        }
        cursor.close();
        db.close();

        return libraryPOJOS;
    }
    public Cursor getSelectedBook(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+TABLENAME +" where id=1";
        //String query = "select * from users where username = 'bhawana'";

        Cursor crs = db.rawQuery(query,null);
        return crs;
    }
    public String updateBookOnClick(String id, String title, String description, String author, String price){ //we can change string with boolean if returning true or false
        //return "ok";
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("title",title);
        cv.put("description",description);
        cv.put("author",author);
        cv.put("price",price);

        // long res = db.update(TABLENAME, null,cv);
        //String query = "update "+TABLENAME +" set title"+title+" and description"+description+" and author"+author+"" +
        //" and price"+price+" where id=4";
        //String query = "select * from users where username = 'bhawana'";

        //Cursor res = db.rawQuery("update "+TABLENAME +" set title"+title+" and description"+description+" and author"+author+"" +
                //" and price"+price+" where id=4",null);
        //return res;

        int res = db.update(TABLENAME, cv, "id = ?", new String[] { id });
        //return true;
        if (res != 1)
            return "Failed";
        else
            return "Successfully updated";
    }

    public String deleteBookOnClick(String id){

        SQLiteDatabase db = this.getWritableDatabase();

        int res = db.delete(TABLENAME, "id = ?", new String[] { id });
        //return true;
        if (res != 1)
            return "Failed";
        else
            return "Successfully deleted";
    }

}