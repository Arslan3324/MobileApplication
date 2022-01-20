package com.example.funnyface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView mytxt=findViewById(R.id.name);
        ImageView img= findViewById(R.id.im);
        setContentView(R.layout.activity_main);
        mytxt.setText("i am hungry");
        img.setImageResource(R.drawable.angry);

    }
    public  void changepic(View view){


    }
}
