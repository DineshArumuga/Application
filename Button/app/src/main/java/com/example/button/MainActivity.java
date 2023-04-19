package com.example.button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.lang.String;

public class MainActivity extends AppCompatActivity {

    Button login_button,cancel_button,hint_button;
    EditText name,pass;
    TextView invalidtext;

    RelativeLayout relative;
    public boolean checkfunction(String user,String pass) //Method Definition Username and Password
    {
        String name =new String("Dinesh");
        String pass1 = new String("1234");
        if(name.equals(user)&&pass1.equals(pass))
        {
            return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_button = findViewById(R.id.loginbutton);
        cancel_button = findViewById(R.id.cancelbutton);
        name = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        invalidtext = findViewById(R.id.invalid);
        hint_button = findViewById(R.id.hint);
        relative = findViewById(R.id.layout);

        //Login button Action
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkfunction(name.getText().toString(),pass.getText().toString())) //Method Calling checking the Username and password
                {
                    Intent i = new Intent(MainActivity.this,login.class);
                    startActivity(i);
                    invalidtext.setVisibility(View.INVISIBLE);
                }
                else {
                    invalidtext.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Invalid Username and Password",Toast.LENGTH_LONG).show(); //Toast Message
                }
            }
        });
        //Cancel Button Action
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDailogMessage(); //Method calling
                invalidtext.setVisibility(View.INVISIBLE);
            }
        });

        //Hint button Action
        hint_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(relative,"User name : Dine** Password : 123*",Snackbar.LENGTH_INDEFINITE)
                        .setAction("Close", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }
        });



    }

    //Method definition for Dailog Message
    private void showDailogMessage() {
        AlertDialog.Builder alertDailog = new AlertDialog.Builder(this);
        alertDailog.setTitle("Cancel")
                .setMessage("Do you want remove user and password")
                //No button Action
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                //Yes button Action
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        name.setText("");
                        pass.setText("");
                    }
                }).show();
    }

}