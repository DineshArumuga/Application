package com.example.checkactivity;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    TextView t;
    int count = 0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = b1.findViewById(R.id.button);
        b2 = b2.findViewById(R.id.button2);
        t = t.findViewById(R.id.textView);
        b1.setOnClickListener(view -> {
            count = count + 1;
            t.setText(""+count);
        });
        b2.setOnClickListener(view -> {
            Intent i = new Intent(new Intent(MainActivity.this,MainActivity2.class));
            startActivity(i);
        });
        Log.d("message","First OnCreate:");
    }

    @Override
    protected void onStart() {
            super.onStart();
            Log.d("message","First OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message","First OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message","First OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message","First OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message","First OnDestroy");
    }
}