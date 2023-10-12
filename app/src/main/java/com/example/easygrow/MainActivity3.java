package com.example.easygrow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity3 extends AppCompatActivity {
  Button button;
  EditText editText, editText1;
   DatabaseReference moistureRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = findViewById(R.id.button4) ;


        // Initialize EditText
        editText = findViewById(R.id.editTextTextPersonName4);
        editText1 = findViewById(R.id.editTextTextPersonName2);


        // Initialize Firebase Realtime Database reference
        moistureRef = FirebaseDatabase.getInstance().getReference().child("moisture");

        // Add a ValueEventListener to retrieve the moisture value from Firebase
        moistureRef.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the moisture value from the dataSnapshot
                Long moistureValue = dataSnapshot.child("average").getValue(Long.class);
                if (moistureValue != null) {
                    // Set the moisture value in the EditText
                    editText.setText(String.valueOf(moistureValue));
                }

                if (moistureValue < 50) {
                    // Motor is on
                    editText1.setText("IRRIGATION HAPPENING");
                } else {
                    // Motor is off
                    editText1.setText("IRRIGATION STOPPED");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error
            }
        });


        button.setOnClickListener(view -> {
            Intent intent= new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);

        });

    }


}