package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'myapplication' library on application startup.
    static {
        System.loadLibrary("myapplication");
    }


    double number1,number2,Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Result = findViewById(R.id.result);
   /*     TextView Check1 = findViewById(R.id.check1);
        TextView Check2 = findViewById(R.id.check2);*/
        EditText Num1 = findViewById(R.id.num1);
        EditText Num2 = findViewById(R.id.num2);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);
        Button next = findViewById(R.id.next);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Double.parseDouble(Num1.getText().toString());
                number2 = Double.parseDouble(Num2.getText().toString());
       /*         Check1.setText(String.valueOf(number1));
                Check2.setText(String.valueOf(number2)); */
                Answer = add(number1,number2);
                Result.setText(String.valueOf(Answer));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Double.parseDouble(Num1.getText().toString());
                number2 = Double.parseDouble(Num2.getText().toString());
                Answer = sub(number1,number2);
                Result.setText(String.valueOf(Answer));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Double.parseDouble(Num1.getText().toString());
                number2 = Double.parseDouble(Num2.getText().toString());
                Answer = mul(number1,number2);
                Result.setText(String.valueOf(Answer));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1 = Double.parseDouble(Num1.getText().toString());
                number2 = Double.parseDouble(Num2.getText().toString());
                Answer = div(number1,number2);
                Result.setText(String.valueOf(Answer));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,overloading.class);
                startActivity(intent);
            }
        });




    }

    /**
     * A native method that is implemented by the 'myapplication' native library,
     * which is packaged with this application.
     */
    public native double add(double a,double b);
    public native double sub(double a,double b);
    public native double mul(double a,double b);
    public native double div(double a,double b);

}