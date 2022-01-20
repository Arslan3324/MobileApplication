package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  "MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignUp(View view)
    {

        Intent intent = new Intent(this,activity_sign_up.class);
        startActivity(intent);
        finish();


    }

    public void Login(View view) {
        TextView emailField = findViewById(R.id.loginEmail);
        TextView passwordField = findViewById(R.id.loginPass);

        SharedPreferences registeredData = getSharedPreferences("registeredData", Context.MODE_PRIVATE);
        String email = registeredData.getString("email",null);
        String password = registeredData.getString("password",null);
        if(passwordField.getText().toString().equals(password))
        {
            Toast.makeText(this,"password matched",Toast.LENGTH_LONG).show();
        }
        if(emailField.getText().toString().equals(email))
        {
            Toast.makeText(this,"email matched",Toast.LENGTH_LONG).show();
        }
        Log.d(TAG, "Login: "+email+ " "+ password );



    }
}