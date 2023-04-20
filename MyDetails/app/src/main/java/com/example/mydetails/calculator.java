package com.example.mydetails;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculator extends AppCompatActivity {

    Button btnAC,btnDEL,btnminus,btnplus,btndiv,btnequal,btnmul,btn9,btn8,btn7,btn6,btn5,btn4,btn3,btn2,btn1,btn0,btndot;
    private TextView textViewresult,textViewhistory;
    String number = null,status = null;
    double firstnumber = 0,secondnumber = 0;
    boolean operator = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textViewhistory = findViewById(R.id.textViewHistory);
        textViewresult = findViewById(R.id.textViewResult);

        btnAC = findViewById(R.id.btnAC);
        btnDEL = findViewById(R.id.btnDEL);
        btnminus = findViewById(R.id.btnminus);
        btnplus = findViewById(R.id.btnplus);
        btndiv = findViewById(R.id.btndiv);
        btnequal = findViewById(R.id.btnequal);
        btnmul = findViewById(R.id.btnmul);
        btn9 = findViewById(R.id.btn9);
        btn8 = findViewById(R.id.btn8);
        btn7 = findViewById(R.id.btn7);
        btn6 = findViewById(R.id.btn6);
        btn5 = findViewById(R.id.btn5);
        btn4 = findViewById(R.id.btn4);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn0 = findViewById(R.id.btn0);
        btndot = findViewById(R.id.btndot);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_click("9");
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator)
                {
                    if(status == "Addition")
                    {
                        plus();
                    }
                    else if (status == "Subtraction")
                    {
                        minus();
                    }
                    else if(status == "Divide")
                    {
                        divide();
                    }
                    else {
                        multiplication();
                    }
                }
                status = "Multiplication";
                operator = true;
                number = null;

            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(operator)
                {
                    if(status == "Multiplication")
                    {
                        minus();
                    }
                    else if (status == "Subtraction")
                    {
                        minus();
                    }
                    else if(status == "Divide")
                    {
                        divide();
                    }
                    else {
                        plus();
                    }
                }
                status = "Addition";
                operator = true;
                number = null;
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(operator)
                {
                    if(status == "Addition")
                    {
                        plus();
                    }
                    else if (status == "Subtraction")
                    {
                        minus();
                    }
                    else if(status == "Multiplication")
                    {
                        multiplication();
                    }
                    else {
                        divide();
                    }
                }
                status = "Divide";
                operator = true;
                number = null;
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator)
                {
                    if(status == "Addition")
                    {
                        plus();
                    }
                    else if (status == "Multiplication")
                    {
                        multiplication();
                    }
                    else if(status == "Divide")
                    {
                        divide();
                    }
                    else {
                        minus();
                    }
                }
                status = "Subtraction";
                operator = true;
                number = null;
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void number_click(String view)
    {
        if(number == null)
        {
            number = view;
        }
        else
        {
            number = number + view;
        }
        textViewresult.setText(""+number);
    }
    public void plus()
    {
        secondnumber = Double.parseDouble(textViewresult.getText().toString()); //ParseDouble is converts String to Double
        firstnumber = secondnumber + firstnumber;
        textViewresult.setText(""+firstnumber);
    }
    public void minus()
    {
        if(firstnumber == 0)
        {
            firstnumber = Double.parseDouble(textViewresult.getText().toString()); //ParseDouble is converts String to Double
        }
        else {
            secondnumber = Double.parseDouble(textViewresult.getText().toString()); //ParseDouble is converts String to Double
            firstnumber = secondnumber - firstnumber;
        }
        textViewresult.setText(""+firstnumber);
    }
    public void divide()
    {
        if(firstnumber == 0) {
            secondnumber = Double.parseDouble(textViewresult.getText().toString()); //ParseDouble is converts String to Double
            firstnumber = secondnumber / 1;
        }
        else {
            secondnumber = Double.parseDouble(textViewresult.getText().toString()); //ParseDouble is converts String to Double
            firstnumber = firstnumber / secondnumber;
        }
        textViewresult.setText(""+firstnumber);
    }
    public void multiplication()
    {
        if(firstnumber == 0) {
            firstnumber = 1;
            secondnumber = Double.parseDouble(textViewresult.getText().toString()); //ParseDouble is converts String to Double
            firstnumber = secondnumber * firstnumber;
        }
        else
        {
            secondnumber = Double.parseDouble(textViewresult.getText().toString()); //ParseDouble is converts String to Double
            firstnumber = secondnumber * firstnumber;
        }
        textViewresult.setText(""+firstnumber);
    }

}