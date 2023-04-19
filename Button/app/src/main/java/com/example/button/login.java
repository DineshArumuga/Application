package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button personaldetails;
        personaldetails = findViewById(R.id.personaldetail);
        personaldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,personal_details.class);
                startActivity(intent);
            }
        });

        Button educationaldetails;
        educationaldetails = findViewById(R.id.educationaldetail);
        educationaldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,educationaldetails.class);
                startActivity(i);
            }
        });

        Button companydetails;
        companydetails = findViewById(R.id.companydetail);
        companydetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,company_details.class);
                startActivity(intent);
            }
        });

        Button resume;
        resume = findViewById(R.id.resume);
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,resume.class);
                startActivity(intent);
            }
        });


    }
}