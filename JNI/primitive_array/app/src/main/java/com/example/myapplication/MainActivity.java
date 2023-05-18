package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myapplication' library on application startup.
    static {
        System.loadLibrary("myapplication");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
        int[] intarray = setarray(0,5,5);

        String numberString = Arrays.toString(intarray); //Int array to string converting
        tv.setText("C++ to Java ----> "+numberString);

        TextView tv1 = binding.textView;
        int intvalue = getarray(intarray);
        tv1.setText("Sum of the Array ---> "+String.valueOf(intvalue));
    }
    private native int[] setarray(int start,int end ,int num);
    private native int getarray(int[] array);
    public native String stringFromJNI();
}