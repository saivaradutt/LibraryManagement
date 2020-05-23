package com.example.myproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.Adapters.ListAdapter;
import com.example.myproject.Entity.LibraryPOJO;

import java.util.ArrayList;

public class ListAllProductsActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    ArrayList arrayList;
    ArrayList<LibraryPOJO> libraryList = new ArrayList<>();
    DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_products);

        listView = (ListView) findViewById(R.id.list_ItemsView);

        dbManager = new DbManager(ListAllProductsActivity.this);

        libraryList = dbManager.getAllBooks();

        ListAdapter listAdapter = new ListAdapter(ListAllProductsActivity.this, R.id.gone, libraryList);
        listView.setAdapter(listAdapter);
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
    @Override
    public void onBackPressed() {
        return;
    }
}
