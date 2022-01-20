package com.example.exampractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        TextView imageView =  findViewById(R.id.nameView);
//        registerForContextMenu(imageView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public void method(View view)
    {
        Intent intent = new Intent(this,NewScreen.class);
        EditText data = findViewById(R.id.name);
        String text = data.getText().toString();
        intent.putExtra("name",text);
        startActivity(intent);
    }

    public void exitMethod(MenuItem item)
    {

    }

    public void guestMethod(MenuItem item) {

        Intent intent = new Intent(this,NewScreen.class);
        intent.putExtra("name","Guest");
        startActivity(intent);
    }

    public void shared (View v){
//        SharedPreferences pref = getSharedPreferences("storage", Context.MODE_PRIVATE);
//         SharedPreferences.Editor editor = pref.edit();
//
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
    }
}