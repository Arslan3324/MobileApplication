package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void showLogin(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void register(View view) {

        TextView fullName = findViewById(R.id.fullNText);
        TextView email = findViewById(R.id.loginEmail);
        TextView password = findViewById(R.id.loginPass);



        Intent intent = new Intent(this,MainActivity.class);
        SharedPreferences registeredData = getSharedPreferences("registeredData", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = registeredData.edit();
        edit.putString("name",fullName.getText().toString());
        edit.putString("email",email.getText().toString());
        edit.putString("password",password.getText().toString());
        edit.apply();

        startActivity(intent);
        finish();
    }
}