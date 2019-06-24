package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.viewHolder> {

    private Mylist[] listData;

    public MyListAdapter(Mylist[] listData){
        this.listData = listData;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.mylist,viewGroup,false);
        viewHolder viewho = new viewHolder(v);
        return viewho;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final Mylist myListData = listData[position];
        holder.txt.setText(listData[position].getDescription());
        holder.img1.setImageResource(listData[position].getImageId());

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public static  class viewHolder extends RecyclerView.ViewHolder{
        public ImageView img1;
        public TextView txt;
        public LinearLayout linear;

        viewHolder(View item){
            super(item);
            this.img1 = (ImageView) item.findViewById(R.id.img);
            this.txt = (TextView) item.findViewById(R.id.tv);
            linear = (LinearLayout)item.findViewById(R.id.ll);
        }
    }
}
