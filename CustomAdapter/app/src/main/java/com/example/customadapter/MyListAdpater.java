package com.example.customadapter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customadapter.R;

class  MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imageid;

    public MyListAdapter(Activity context, String[] maintitle, Integer[] imageid){
        super(context,R.layout.mylist,maintitle);

        this.context = context;
        this.maintitle = maintitle;
        this.imageid = imageid;
    }

    public View getView(int position, View view , ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist,null,true);

        TextView textview = (TextView)rowView.findViewById(R.id.tv1);
        ImageView img1 = (ImageView)rowView.findViewById(R.id.img);

        textview.setText(maintitle[position]);
        img1.setImageResource(imageid[position]);

        return rowView;


    }

}