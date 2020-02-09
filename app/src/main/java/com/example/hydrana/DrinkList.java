package com.example.hydrana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.hydrana.Interface.ItemClickListener;
import com.example.hydrana.ViewHolder.DrinkViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DrinkList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference drinkList;

    String CategoryId="";

    FirebaseRecyclerAdapter<Drink, DrinkViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_list);

        //Firebase

        database = FirebaseDatabase.getInstance();
        drinkList = database.getReference("Drink");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_drink);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get intent

        if (getIntent() != null)
            CategoryId = getIntent().getStringExtra("CategoryId");
        if (!CategoryId.isEmpty() && CategoryId != null){


            LoadListFood (CategoryId);

        }


    }

    private void LoadListFood (String categoryId) {

        adapter = new FirebaseRecyclerAdapter<Drink, DrinkViewHolder>(Drink.class,R.layout.drink_item,DrinkViewHolder.class,drinkList.orderByChild("MenuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(DrinkViewHolder viewHolder, Drink model, int position) {

                viewHolder.food_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.food_image);

                final Drink local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Toast.makeText(DrinkList.this, ""+local.getName(),Toast.LENGTH_SHORT).show();

                    }
                });

            }
        };

        //set adapter
        Log.d("TAG",""+ adapter.getItemCount());
        recyclerView.setAdapter(adapter);

    }

}
