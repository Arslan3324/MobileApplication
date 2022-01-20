package com.example.arslanahmed_midone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adduser(View view)
    {
        TextView one = findViewById(R.id.useronename);
        TextView two = findViewById(R.id.usertwoname);

        SharedPreferences preferences = getSharedPreferences("usernames", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user1",one.getText().toString());
        editor.putString("user2",two.getText().toString());
        editor.apply();

        Toast.makeText(this,"User Addded",Toast.LENGTH_LONG).show();


    }

    public  void play(View view)
    {
        Intent intent = new Intent(this,game.class);
        startActivity(intent);
    }
}