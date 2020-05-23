package com.example.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewBookActivity extends AppCompatActivity {
    EditText title,description,author, price;
    //ImageView imagePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);
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

   public void addNewBookOnClick(View view){

        title = (EditText) findViewById(R.id.add_title);
        description = (EditText) findViewById(R.id.add_description);
        author = (EditText)findViewById(R.id.add_author);
        price = (EditText) findViewById(R.id.add_price);
        //imagePath = (ImageView) findViewById(R.id.add)

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
