package com.example.activitiesarslan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CREATION","onCreate() is being Executed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("START","onStart() is being Executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("RESUME","onResume() is being Executed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PAUSE","onPause() is being Executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STOP","onStop() is being Executed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("RESTART","onRestart() is being Executed");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DESTROY","onDestroy() is being Executed");
    }
}
