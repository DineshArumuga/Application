package com.example.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.add.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'add' library on application startup.
    static {
        System.loadLibrary("add");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int a=2;
        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI(a));
    }

    /**
     * A native method that is implemented by the 'add' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(int i);
}