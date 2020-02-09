package com.example.hydrana.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hydrana.Interface.ItemClickListener;
import com.example.hydrana.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView drink_name;
    public ImageView drink_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener (ItemClickListener itemClickListener) {

        this.itemClickListener = itemClickListener;

    }

    public DrinkViewHolder (View itemView ) {

        super(itemView);

        drink_name = (TextView)itemView.findViewById(R.id.drink_name);
        drink_image = (ImageView)itemView.findViewById(R.id.drink_image);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
