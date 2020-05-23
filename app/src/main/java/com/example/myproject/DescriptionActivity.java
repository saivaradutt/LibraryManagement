package com.example.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        IntentContent();
        spinnerCreate();

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
    public void IntentContent(){

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String author = intent.getStringExtra("Author");
        String description = intent.getStringExtra("Description");
        String price = intent.getStringExtra("Price");

        TextView descTitle = (TextView)findViewById(R.id.descTitle);
        TextView descAuthor= (TextView)findViewById(R.id.descAuthor);
        TextView descDescription = (TextView)findViewById(R.id.descDescription);
        TextView descPrice = (TextView)findViewById(R.id.descPrice);

         descTitle.setText(title);
         descAuthor.setText(author);
         descDescription.setText(description);
         descPrice.setText(price);

    }

    public void cartBtnClicked(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(DescriptionActivity.this);
        builder.setMessage("Proceed to checkout");

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(DescriptionActivity.this,ListUserProductsActivity.class));

            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Intent intent = new Intent(DescriptionActivity.this, CheckoutActivity.class);
//                Intent intent = new Intent(DescriptionActivity.this, CheckoutActivity.class);
//                intent.putExtra("Title", title);
//                intent.putExtra("Price", intent_price);
                startActivity(new Intent(DescriptionActivity.this, CheckoutActivity.class));
            }
        });
        builder.create().show();
    }

    public void spinnerCreate(){

        Spinner dropdown = findViewById(R.id.descSpinner);
        //create a list of items for the spinner.

        String[] items = new String[]{"1", "2", "3", "4", "5"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.

        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

}
