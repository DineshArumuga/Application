
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class overloading extends AppCompatActivity {

    double a,b,c,result;
    EditText num1,num2,num3;
    Button ans;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overloading);
        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        num3 = findViewById(R.id.number3);
        res = findViewById(R.id.Result);
        ans = findViewById(R.id.Answer);

        ans.setOnClickListener(view -> {
            a = Double.parseDouble(num1.getText().toString());
            b = Double.parseDouble(num2.getText().toString());
            c = Double.parseDouble(num3.getText().toString());
         //   result = add(a);
          //  result = add(a,b);
            result = add(a,b,c);
            res.setText(String.valueOf(result));
        });

    }
    public native double add(double a);
    public native double add(double a,double b);
    public native double add(double a,double b,double c);




}