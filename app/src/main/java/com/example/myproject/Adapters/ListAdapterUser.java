package com.example.myproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myproject.Entity.LibraryPOJO;
import com.example.myproject.R;

import java.util.ArrayList;

public class ListAdapterUser extends ArrayAdapter<String> {

    Context context;
    ArrayList<LibraryPOJO> values;

    public ListAdapterUser(@NonNull Context context, int resource, @NonNull ArrayList<LibraryPOJO> values) {

        super(context, resource);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public long getItemId(int position) {
        return (position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_view_books_user, parent, false);

        TextView name =(TextView)view.findViewById(R.id.ViewBooksTitle);
        //ImageView iv_image =(ImageView)view.findViewById(R.id.ViewBooksImage);
        TextView price =(TextView)view.findViewById(R.id.ViewBooksPrice);

        name.setText(values.get(position).getTitle());
        price.setText(String.valueOf(values.get(position).getPrice()));

        return view;
    }
}
