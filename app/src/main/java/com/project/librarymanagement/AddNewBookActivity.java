package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewBookActivity extends AppCompatActivity {
    EditText title,description,author, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);
    }
    public void addNewBookOnClick(View view){

        title = (EditText) findViewById(R.id.add_title);
        description = (EditText) findViewById(R.id.add_description);
        author = (EditText)findViewById(R.id.add_author);
        price = (EditText) findViewById(R.id.add_price);
        if ( !TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()) && !TextUtils.isEmpty(author.getText().toString()) && !TextUtils.isEmpty(price.getText().toString()))
        {
            addMethod();
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddNewBookActivity.this);

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
    public void addMethod(){
        DbManager db = new DbManager(this);
        String res = db.addNewBookOnClick(title.getText().toString(), description.getText().toString(), author.getText().toString(), price.getText().toString());
        //Toast.makeText(this, "New Book Added", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();

        title.setText("");
        description.setText("");
        author.setText("");
        price.setText("");
    }
}
