package com.example.arslanmid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("CMSLOGIN", MODE_PRIVATE);


        if (sharedPreferences.getBoolean("isLogin", false) == true) {
            intent = new Intent(this, Activity2.class);
            startActivity(intent);
        } else {
            return;
        }
    }




    public void onClick(View v)
    {
        user = (EditText) findViewById(R.id.edit_user);
        pass = (EditText) findViewById(R.id.edit_pass);
        sharedPreferences = getSharedPreferences("CMSLOGIN",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (user.getText().toString().contentEquals(sharedPreferences.getString("username", "023-18-0082"))
                && pass.getText().toString().contentEquals(sharedPreferences.getString("password", "12345"))) {

            editor.putBoolean("isLogin", true).apply();
            editor.commit();
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Invalid password or username", Toast.LENGTH_LONG).show();
        }
    }
}