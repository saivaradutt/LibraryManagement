package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.ListUserProductsActivity;

public class AdminHomePage extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

        imageView = (ImageView)findViewById(R.id.main_logoImage);
        imageView.setImageResource(R.drawable.logo);

        //listView = (ListView) findViewById(R.id.main_listview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Item1:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {

                getMenuInflater().inflate(R.menu.menu_logout, menu);
                return super.onCreateOptionsMenu(menu);
            }
            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Item1:
                        startActivity(new Intent(this, MainActivity.class));
                        break;
                }

                return super.onOptionsItemSelected(item);
            }
        */
    public void viewAllBooks(View view){
        Intent intent = new Intent(this, ListAllProductsActivity.class);
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
        //Toast.makeText(this, "will be delete functionality", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DeleteBookRecordActivity.class);
        startActivity(intent);
    }

}
