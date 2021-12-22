package com.example.scrimish_intro;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout p1name,p2name;
    SharedPreferences pfs;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1name=findViewById(R.id.p1name);
        p2name=findViewById(R.id.p2name);
        pfs= getSharedPreferences("names",MODE_PRIVATE);
    }
    public void play(View v){
        p1name.setError(null);
        p1name.setErrorEnabled(false);

        p2name.setError(null);
        p2name.setErrorEnabled(false);
        String player1,player2;
        player1=p1name.getEditText().getText().toString();
        player2=p2name.getEditText().getText().toString();

//
        if(player1.equals("")){
            p1name.setError("Please enter name");
            return;
        }
        if(player2.equals("")){
            p2name.setError("Please enter name");
            return;
        }
        editor=pfs.edit();
        Intent intent = new Intent(this, activity_game.class);
        editor.putString("p1name",p1name.getEditText().getText().toString());
        editor.putString("p2name",p2name.getEditText().getText().toString());
        editor.apply();
        startActivity(intent);
    }
}