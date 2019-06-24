package com.upgrad.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    private final Activity context;

    private final String[] maintitle;

    public MyAdapter(Activity context, String[] maintitle) {
        super(context,R.layout.listview_row,maintitle);

        this.context = context;
        this.maintitle = maintitle;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row,null,true);

        TextView textview = (TextView)rowView.findViewById(R.id.txv1);
        textview.setText(maintitle[position]);
        return rowView;
    }
}
