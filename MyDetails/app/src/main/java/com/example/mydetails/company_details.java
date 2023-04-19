package com.example.mydetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class company_details extends AppCompatActivity {

    Button experience;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        experience = findViewById(R.id.experience);
        experience.setOnClickListener(view -> {
            Intent i = new Intent(company_details.this,experience.class);
            startActivity(i);
        });
    }
}