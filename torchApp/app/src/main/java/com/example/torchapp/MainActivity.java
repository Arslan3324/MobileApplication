package com.example.torchapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean torchState = false;
    private CameraManager cameraManager;
    private String getCameraID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            // O means back camera unit,
            // 1 means front camera unit
            getCameraID = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void toggleTorch(View view) {
        Button btn = (Button) view;

        try {
            // true sets the torch in ON mode
            if (!torchState) {
                torchState = true;
                cameraManager.setTorchMode(getCameraID, torchState);
                btn.setText("Click to Off the Torch");
            } else {

                torchState = false;
                cameraManager.setTorchMode(getCameraID, torchState);
                btn.setText("Click to On the Torch");

            }

            // Inform the user about the flashlight
            // status using Toast message
            Toast.makeText(MainActivity.this, "Flashlight is turned ON", Toast.LENGTH_SHORT).show();
        } catch (CameraAccessException e) {
            // prints stack trace on standard error
            // output error stream
            e.printStackTrace();
        }
    }
}