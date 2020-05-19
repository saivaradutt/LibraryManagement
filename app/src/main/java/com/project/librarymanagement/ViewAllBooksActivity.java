package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAllBooksActivity extends AppCompatActivity {

    DbManager obj = null;
    TextView title,description,author,price;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_books);

        title = (TextView) findViewById(R.id.books_title);
        description = (TextView) findViewById(R.id.books_description);
        author = (TextView) findViewById(R.id.books_author);
        price = (TextView) findViewById(R.id.books_price);

        obj = new DbManager(this);
        Cursor result = obj.getAllBooks(); // Cursor holds a complete row
       // Toast.makeText(this, "hello "+result, Toast.LENGTH_LONG).show();

        //startActivity(new Intent(this, AfterLoginActivity.class));
        StringBuffer buffer = new StringBuffer();

        while(result.moveToNext()){
            id = result.getString(0);
            title.setText(result.getString(1));
            description.setText(result.getString(2));
            author.setText(result.getString(3));
            price.setText(result.getString(4));
            //Toast.makeText(this, result.getString(1), Toast.LENGTH_SHORT).show();
        }

    }

    public void updateBtnClicked(View view) {
        //startActivity(new Intent(this, UpdateBookDetailActivity.class));

    }

    public void deleteBtnClicked(View view) {
        //startActivity(new Intent(this, DeleteBookDetailActivity.class));
    }
}
