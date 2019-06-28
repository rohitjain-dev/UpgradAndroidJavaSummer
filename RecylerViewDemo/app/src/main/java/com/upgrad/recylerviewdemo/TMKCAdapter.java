package com.upgrad.recylerviewdemo;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class TMKCAdapter extends RecyclerView.Adapter<TMKCAdapter.viewHolder> {

    private TMKC[] data;


    public TMKCAdapter(TMKC[] data) {
        this.data = data;
    }

    @Override
    public viewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.character_row,viewGroup,false);
        viewHolder viewHolder = new viewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
       // TMKC mylistData = data[position];
        holder.characternameText.setText(data[position].getCharaterName());
        holder.characterTaglineText.setText(data[position].getTagLine());
        holder.characterImage.setImageResource(data[position].getImgID());
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    //Viewholder inner class
    public class viewHolder extends RecyclerView.ViewHolder{
        TextView characternameText;
        TextView characterTaglineText;
        ImageView characterImage;

        public viewHolder(View itemView) {
            super(itemView);
            characternameText = (TextView) itemView.findViewById(R.id.textviewname);
            characterTaglineText = (TextView) itemView.findViewById(R.id.textViewtagline);
            characterImage = (ImageView) itemView.findViewById(R.id.imageviewcharacter);
        }
    }
}
