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

        title = (EditText) findViewById(R.id.update_title);
        description = (EditText) findViewById(R.id.update_description);
        author = (EditText) findViewById(R.id.update_author);
        price = (EditText) findViewById(R.id.update_price);

        Intent intent= getIntent();
        if(intent != null || !intent.getExtras().isEmpty()) {
            retrievedId = intent.getStringExtra("id");
        }
        //Toast.makeText(this, ""+retrievedId, Toast.LENGTH_SHORT).show();

        obj = new DbManager(this);
        Cursor result = obj.getSelectedBook(id); // Cursor holds a complete row
        //Toast.makeText(this, "hello "+result, Toast.LENGTH_LONG).show();

        while(result.moveToNext()){
            id = result.getString(0);
            title.setText(result.getString(1));
            description.setText(result.getString(2));
            author.setText(result.getString(3));
            price.setText(result.getString(4));
            //Toast.makeText(this, result.getString(1), Toast.LENGTH_SHORT).show();
        }
    }
    public void updateBookDetailOnClick(View view){
        title = (EditText) findViewById(R.id.update_title);
        description = (EditText) findViewById(R.id.update_description);
        author = (EditText) findViewById(R.id.update_author);
        price = (EditText) findViewById(R.id.update_price);

        if ( !TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()) && !TextUtils.isEmpty(author.getText().toString()) && !TextUtils.isEmpty(price.getText().toString()))
        {
            updateMethod();
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(UpdateBookDetailActivity.this);

            builder.setTitle("Please fill all fields.");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
            builder.create().show();
        }
    }
    public void updateMethod(){
    }
}
