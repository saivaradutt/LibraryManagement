package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.main_logoImage);
        imageView.setImageResource(R.drawable.logo);

        //listView = (ListView) findViewById(R.id.main_listview);
    }
    public void viewAllBooks(View view){
        Intent intent = new Intent(this, ViewAllBooksActivity.class);
        startActivity(intent);
    }
    public void addNewBook(View view){
        Intent intent = new Intent(this, AddNewBookActivity.class);
        startActivity(intent);
    }
    public void updateBookDetail(View view){
        Intent intent = new Intent(this, UpdateBookDetailActivity.class);
        startActivity(intent);
    }
    public void deleteBookRecord(View view){
        Toast.makeText(this, "will be delete functionality", Toast.LENGTH_SHORT).show();
    }
}
