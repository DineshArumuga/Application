package com.example.mydetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);
        Button addition = findViewById(R.id.add);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(first_game.this,first_addition.class);
                startActivity(intent);
            }
        });

        Button subtraction = findViewById(R.id.sub);
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(first_game.this,first_subtraction.class);
                startActivity(intent);
                finish();
            }
        });

        Button multiplication = findViewById(R.id.mul);
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(first_game.this,first_multiplication.class);
                startActivity(intent);
                finish();
            }
        });
    }


}