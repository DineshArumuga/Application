package com.example.mydetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class firstpage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        Button first = findViewById(R.id.firstbutton);
        first.setOnClickListener(view -> {
            Intent intent = new Intent(firstpage.this,login.class);
            startActivity(intent);
        });

        Button second = findViewById(R.id.firstbutton2);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstpage.this,first_game.class);
                startActivity(intent);
            }
        });

        Button calculator;
        calculator = findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(firstpage.this,calculator.class);
                    startActivity(intent);
            }
        });
    }
}