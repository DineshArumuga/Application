package com.example.mydetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class first_result extends AppCompatActivity {

    TextView score;
    Button playagain,exit;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_result);
        score = findViewById(R.id.score);
        playagain = findViewById(R.id.playagain);
        exit = findViewById(R.id.exit);
        Intent i = getIntent();
        result = i.getIntExtra("score",0);
        String res = String.valueOf(result);
        score.setText("Score : " + res);

        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(first_result.this,first_game.class);
                startActivity(intent);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(first_result.this,firstpage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}