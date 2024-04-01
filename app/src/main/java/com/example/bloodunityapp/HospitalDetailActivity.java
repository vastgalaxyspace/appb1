package com.example.bloodunityapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HospitalDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HospitalDetailActivity.this, DontateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        FloatingActionButton fab = findViewById(R.id.map);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Generate random latitude and longitude values
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Mumbai");

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

// Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

// Attempt to start an activity that can handle the Intent
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
        // Get the details from the intent
        String hospitalName = getIntent().getStringExtra("hospitalName");
        String hospitalAddress = getIntent().getStringExtra("hospitalAddress");

        int hospitalImage = getIntent().getIntExtra("hospitalImage", 0);

        // Find the views in your layout
        TextView nameView = findViewById(R.id.name_view);
        TextView addressView = findViewById(R.id.address_view);

        ImageView imageView = findViewById(R.id.image_view);

        // Set the details to the views
        nameView.setText(hospitalName);
        addressView.setText(hospitalAddress);
        imageView.setImageResource(hospitalImage);


    }
}