package com.example.myproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.Adapters.ListAdapterUser;
import com.example.myproject.Entity.LibraryPOJO;

import java.util.ArrayList;

public class ListUserProductsActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    ArrayList arrayList;
    ArrayList<LibraryPOJO> libraryList = new ArrayList<>();
    DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_products);

        listView = (ListView) findViewById(R.id.list_BooksView);

        dbManager = new DbManager(ListUserProductsActivity.this);

        libraryList = dbManager.getAllBooks();

        ListAdapterUser listAdapter = new ListAdapterUser(ListUserProductsActivity.this, R.id.gone, libraryList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String po = String.valueOf(position);
                Intent intent = new Intent(ListUserProductsActivity.this, DescriptionActivity.class);
                //intent.putStringArrayListExtra("List", libraryList);
                intent.putExtra("Title", libraryList.get(position).getTitle());
                intent.putExtra("Author", libraryList.get(position).getAuthor());
                intent.putExtra("Description", libraryList.get(position).getDescription());

                String price = String.valueOf(libraryList.get(position).getPrice());
                intent.putExtra("Price", price);

                startActivity(intent);
            }
        });

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
