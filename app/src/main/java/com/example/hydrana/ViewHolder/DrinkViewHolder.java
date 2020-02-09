package com.example.hydrana.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hydrana.Interface.ItemClickListener;
import com.example.hydrana.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView food_name;
    public ImageView food_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener (ItemClickListener itemClickListener) {

        this.itemClickListener = itemClickListener;

    }

    public DrinkViewHolder (View itemView ) {

        super(itemView);

        food_name = (TextView)itemView.findViewById(R.id.food_name);
        food_image = (ImageView)itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
