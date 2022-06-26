package com.example.tnr_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<AndroidFeatures> {

    public ListAdapter(Context context, ArrayList<AndroidFeatures> androidArrayList){
        super(context,R.layout.list_item,androidArrayList);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AndroidFeatures android = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.picture);
        TextView name = convertView.findViewById(R.id.name);

        imageView.setImageResource(android.image);
        name.setText(android.name);

        return convertView;
    }
}
