package com.upgrad.gridviewdemo;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DisneyAdapter extends RecyclerView.Adapter<DisneyAdapter.viewHolder> {

     Disney[] data;

    public DisneyAdapter(Disney[] data) {
        this.data = data;
    }

    //return a viewholder
    @Override
    public viewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.custom_row,viewGroup,false);
        viewHolder vh = new viewHolder(v);
        return vh;
    }


    //binding a view
    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
      holder.charatername.setText(data[position].getCharaterName());
      holder.tagline.setText(data[position].getTagLine());
      holder.characterImage.setImageResource(data[position].getImgID());
    }

    //length of my data
    @Override
    public int getItemCount() {
        return data.length;
    }

    //innerclass
    public class viewHolder extends RecyclerView.ViewHolder{

        TextView charatername;
        TextView tagline;
        ImageView characterImage;

        public viewHolder(View itemView) {
            super(itemView);
            charatername = (TextView) itemView.findViewById(R.id.textviewname);
            tagline = (TextView) itemView.findViewById(R.id.textViewtagline);
            characterImage = (ImageView) itemView.findViewById(R.id.imageviewcharacter);
        }
    }

}
