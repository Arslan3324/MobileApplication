package com.example.newtask;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }

    public void LoginNow(View view) {
        EditText Remail = findViewById(R.id.loginemail);
        EditText Rpassword = findViewById(R.id.loginpassword);

        SharedPreferences preferences = getSharedPreferences("task_data", Context.MODE_PRIVATE);
        String Uemail = preferences.getString("email",null);
        String Upass = preferences.getString("pass",null);

        if(Remail.getText().toString().equals(Uemail) && Rpassword.getText().toString().equals(Upass))
        {
            Toast.makeText(this, "MSG: Welcome", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, dice.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this, "MSG: Nikal Lorhu", Toast.LENGTH_LONG).show();

        }


    }

}