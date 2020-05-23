package com.example.myproject.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myproject.Entity.LibraryPOJO;
import com.example.myproject.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<LibraryPOJO> values;

    public String images[] = {"R.drawable.fiftyshades","R.drawable.swift", "R.drawable.csharp"};

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<LibraryPOJO> values) {

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
        View view = inflater.inflate(R.layout.activity_view_all_books, parent, false);

        TextView name =(TextView)view.findViewById(R.id.books_title);
        TextView des = (TextView)view.findViewById(R.id.books_description);
        TextView auth = (TextView)view.findViewById(R.id.books_author);
        ImageView iv_image =(ImageView)view.findViewById(R.id.image);
        TextView price =(TextView)view.findViewById(R.id.books_price);



        name.setText("Ram");
        name.setText(values.get(position).getTitle());
        des.setText(values.get(position).getDescription());
        auth.setText(values.get(position).getAuthor());
        price.setText(String.valueOf(values.get(position).getPrice()));
        //iv_image.setImageResource(Integer.parseInt(images[position]));
        //iv_image.setImageDrawable(Drawable.createFromPath(images[position]));
        //iv_image.setImageURI(Uri.parse(images[position]));

        return view;
    }
}
