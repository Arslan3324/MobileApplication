package com.example.checkboxpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void eyes(View view)
    {
        ImageView imgE= findViewById(R.id.eyeimg);
        CheckBox eye = findViewById(R.id.eyes);
        if(!eye.isChecked())
        {
            imgE.setVisibility(View.INVISIBLE);
        }
        else{
            imgE.setVisibility(View.VISIBLE);
        }


    }
    public void glass(View view)
    {
        ImageView imgG= findViewById(R.id.gimg);
        CheckBox glass = findViewById(R.id.glass);

        if(!glass.isChecked())
        {
            imgG.setVisibility(View.INVISIBLE);
        }
        else{
            imgG.setVisibility(View.VISIBLE);
        }

    }
    public void hat(View view)
    {
        ImageView imgH= findViewById(R.id.himg);



        CheckBox hat = findViewById(R.id.hat);


        if(!hat.isChecked())
        {
            imgH.setVisibility(View.INVISIBLE);
        }
        else{
            imgH.setVisibility(View.VISIBLE);
        }

    }

}