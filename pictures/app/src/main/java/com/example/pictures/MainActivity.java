package com.example.pictures;

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

    public void check1(View view)
    {
        ImageView img1 = findViewById(R.id.img1);
        CheckBox c1 = findViewById(R.id.c1);

        if(c1.isChecked())
        {
            img1.setVisibility(View.VISIBLE);
        }
        else{
            img1.setVisibility(View.INVISIBLE);
        }

    }

    public void check2(View view)
    {
        ImageView img2=findViewById(R.id.img2);
        CheckBox c2=findViewById(R.id.c2);
        if(c2.isChecked())
        {
            img2.setVisibility(View.VISIBLE);
        }
        else
        {
            img2.setVisibility(View.INVISIBLE);
        }
    }

}