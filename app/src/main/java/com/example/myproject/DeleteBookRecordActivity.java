package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DeleteBookRecordActivity extends AppCompatActivity {

    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book_record);
            id = "4";
        DbManager db = new DbManager(this);
        String res = db.deleteBookOnClick(id);
    }
}
