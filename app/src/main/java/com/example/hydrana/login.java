package com.example.hydrana;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hydrana.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;


public class login extends AppCompatActivity {
    EditText editPhone,editPass;

    Button btnLogIn;
    DatabaseReference table_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //init views
        editPhone =  findViewById(R.id.editPhone);
        editPass =  findViewById(R.id.editPass);
        btnLogIn =  findViewById(R.id.btnLogIn);

        //Init Firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        table_user = database.getReference("User");

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(login.this);
                mDialog.setMessage("Chill Kiasi...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Log.d("dataSnap","data"+dataSnapshot.toString());
                        // CHeck User Existence in DB
                        if (dataSnapshot.child(editPhone.getText().toString()).exists()) {

                            // Get User Info
                            mDialog.dismiss();
                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                            //log response from server
                            Log.d("userData","user: "+user.getName()+" || phonenumber:"+user.getNumber()+" || password: "+user.getPassword());
                                if (user.getPassword().equals(editPass.getText().toString())) {

                                    {

                                        Intent homeIntent = new Intent(login.this, home.class);
                                        Common.currentUSer = user;
                                        startActivity(homeIntent);
                                        finish();

                                    }

                            } else {

                                Toast.makeText(login.this, "Incorrect Password", Toast.LENGTH_SHORT).show();

                            }

                        }

                        else

                        {
                            mDialog.dismiss();

                            Toast.makeText(login.this, "User does not exist", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
