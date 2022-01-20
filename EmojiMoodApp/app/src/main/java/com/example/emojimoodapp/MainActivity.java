package com.example.emojimoodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEating(View view)
    {
        Button btn = findViewById(R.id.button);
        TextView text = findViewById(R.id.textView);
        ImageView img = findViewById(R.id.imageView);

        btn.setText("DONE");
        text.setText("I am SO Full");
        img.setImageResource(R.drawable.full);




    }
}