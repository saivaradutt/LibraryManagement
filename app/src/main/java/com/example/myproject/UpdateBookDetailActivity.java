package com.example.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
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

        Intent intent = getIntent();
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
        DbManager db = new DbManager(this);
        String res = db.updateBookOnClick(id, title.getText().toString(), description.getText().toString(), author.getText().toString(), price.getText().toString());
        //Toast.makeText(this, "New Book Added", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, (CharSequence) res,Toast.LENGTH_LONG).show();

        title.setText("");
        description.setText("");
        author.setText("");
        price.setText("");
    }
}
