package com.example.mydetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class educationaldetails  extends AppCompatActivity {

    Button school,diploma,college;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educationaldetails);
        school = findViewById(R.id.schoolcertificate);
        diploma = findViewById(R.id.diplomacertificate);
        college = findViewById(R.id.collegecertificate);

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(educationaldetails.this,school.class);
                startActivity(i1);
            }
        });
        diploma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(educationaldetails.this,diploma.class);
                startActivity(i2);
            }
        });
        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(educationaldetails.this,college.class);
                startActivity(i3);
            }
        });
    }
}