package com.example.easygrow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
 Button button;
 EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button3);
        editText = findViewById(R.id.editTextTextPersonName);

        button.setOnClickListener(view -> {
            String serialNumber = editText.getText().toString().trim();

            // Check if the entered serial number is valid
            if (serialNumber.equals("e4c22j17")) {
                // Serial number is valid, allow login
                Toast.makeText(MainActivity2.this, "Login successful", Toast.LENGTH_SHORT).show();

                // Proceed to the next activity
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            } else {
                // Serial number is invalid, display an error message
                Toast.makeText(MainActivity2.this, "Invalid serial number", Toast.LENGTH_SHORT).show();
            }
         });
    }
}