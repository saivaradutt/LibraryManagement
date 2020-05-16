package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBookDetailActivity extends AppCompatActivity {

    String retrievedId;
    EditText title,description,author,price;
    DbManager obj = null;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book_detail);

    }
    public void updateBookDetailOnClick(View view){
    }
    public void updateMethod(){
    }
}
