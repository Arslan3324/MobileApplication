package com.example.potatogame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MSG";
    ImageView[] array = new ImageView[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        array[0] = findViewById(R.id.glasses);
        array[1] = findViewById(R.id.nose);
        array[2] = findViewById(R.id.mouth);
    }

    public void click(View view)
    {
        CheckBox check= (CheckBox) view;
        String s = check.getTag().toString();
        Integer index = Integer.parseInt(s);

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        Log.d(TAG, "click: "+s);
        if(check.isChecked())
        array[index].setVisibility(View.VISIBLE);
        else
            array[index].setVisibility(View.INVISIBLE);


    }
}