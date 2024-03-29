package com.example.hydrana;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class signup extends AppCompatActivity {

    MaterialEditText editPhone,editPass,editName;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editPhone = (MaterialEditText) findViewById(R.id.editPhone);
        editPass = (MaterialEditText) findViewById(R.id.editPass);
        editName = (MaterialEditText) findViewById(R.id.editName);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        //Init Firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(signup.this);
                mDialog.setMessage("Chill Kiasi...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        // Check if primary key exists

                        if (dataSnapshot.child(editPhone.getText().toString()).exists())

                        {

                            mDialog.dismiss();
                            Toast.makeText(signup.this, "Phone Number already exists", Toast.LENGTH_SHORT).show();

                        }

                        else {

                            mDialog.dismiss();
                            User user = new User(editName.getText().toString(),editPass.getText().toString(),editPhone.getText().toString());
                            table_user.child(editPhone.getText().toString()).setValue(user);
                            Toast.makeText(signup.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            finish();

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
