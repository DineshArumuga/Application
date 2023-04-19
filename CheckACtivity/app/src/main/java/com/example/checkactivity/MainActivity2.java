package com.example.checkactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = findViewById(R.id.button3);
        b.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(i);
        });
        Log.d("message","Second OnCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message","Second OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message","Second OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message","Second OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message","Second OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message","Second OnDestroy");
    }
}