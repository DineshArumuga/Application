package com.example.mydetails;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.lang.String;

public class MainActivity extends AppCompatActivity {

    Button login_button,cancel_button,hint_button;
    EditText name,pass;
    TextView invalidtext;
    ConstraintLayout layout1;
    SharedPreferences sharedPreferences;
    String username,userpassword;
    public boolean Checkfunction(String user, String pass) //Method Definition Username and Password
    {
        String name = new String("Dinesh");
        String pass1 = new String("1234");
        return name.equals(user) && pass1.equals(pass);
    }
    public void saveData()
    {
        sharedPreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        username = name.getText().toString();
        userpassword = pass.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key user",username);
        editor.putString("key pass",userpassword);
        editor.apply();
        Toast.makeText(getApplicationContext(),"Your User and Password is saved",Toast.LENGTH_LONG).show();
    }
    public void retrivedData() {
        sharedPreferences = getSharedPreferences("SaveData",MODE_PRIVATE);
        username = sharedPreferences.getString("key user",null);
        userpassword = sharedPreferences.getString("key pass",null);
        name.setText(username);
        pass.setText(userpassword);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        login_button = findViewById(R.id.loginbutton);
        cancel_button = findViewById(R.id.cancelbutton);
        name = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        invalidtext = findViewById(R.id.invalid);
        hint_button = findViewById(R.id.hint);

        layout1 = findViewById(R.id.constraint);
        //Login button Action
        login_button.setOnClickListener(view -> {
            if(Checkfunction(name.getText().toString(),pass.getText().toString())) //Method Calling checking the Username and password
            {
                Intent i1 = new Intent(MainActivity.this,firstpage.class);
                startActivity(i1);
                invalidtext.setVisibility(View.INVISIBLE);
            }
            else {
                invalidtext.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Invalid Username and Password",Toast.LENGTH_LONG).show(); //Toast Message
            }
        });
        //Cancel Button Action
        cancel_button.setOnClickListener(view -> {
            showDailogMessage(); //Method calling
            invalidtext.setVisibility(View.INVISIBLE);
        });

        //Hint button Action
        hint_button.setOnClickListener(view -> Snackbar.make(layout1,"User name : Dine** Password : 123*",Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", view1 -> {

                }).show());
        retrivedData();
    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        saveData();
        super.onDestroy();
    }

    //Method definition for Dailog Message
    private void showDailogMessage() {
        AlertDialog.Builder alertDailog = new AlertDialog.Builder(this);
        alertDailog.setTitle("Cancel")
                .setMessage("Do you want remove user and password")
                //No button Action
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel())
                //Yes button Action
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    name.setText("");
                    pass.setText("");
                }).show();
    }

}