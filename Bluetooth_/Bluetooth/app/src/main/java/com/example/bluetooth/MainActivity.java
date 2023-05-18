package com.example.bluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnon, btnoff;
    BluetoothAdapter myBluetoothAdapter;
    Intent btEnablingintent;
    int requestcodeforEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnon = findViewById(R.id.btnona);
        btnoff = findViewById(R.id.btnoffb);

        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btEnablingintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        requestcodeforEnable = 1;
        bluetoothOnmethod();
        bluetoothoffmethod();

    }

    private void bluetoothoffmethod() {
        btnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                myBluetoothAdapter.disable();
            }
        });
     }


     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         if (requestCode == requestcodeforEnable) {
             if (resultCode == RESULT_OK) {
                 Toast.makeText(this, "Bluetooth is enable", Toast.LENGTH_SHORT).show();
             } else if (resultCode == RESULT_CANCELED) {
                 Toast.makeText(this, "Bluetooth Enabling cancelled", Toast.LENGTH_SHORT).show();
             }
         }

     }

     private void bluetoothOnmethod() {
        btnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myBluetoothAdapter==null)
                {
                    Toast.makeText(getApplicationContext(),"Bluetooth does nor on this device",Toast.LENGTH_LONG).show();

                }
                else {
                    if (!myBluetoothAdapter.isEnabled())
                    {
                        startActivityForResult(btEnablingintent,requestcodeforEnable);
                    }
                }
            }
        });
     }
 }