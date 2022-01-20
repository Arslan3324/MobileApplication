package com.example.guessnum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random;
    int Rnum;
    int uguess;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random=new Random();
        Rnum=random.nextInt(100);
    }
    public void guessgame(View view){
        editText=findViewById(R.id.pt);
        textView=findViewById(R.id.tv);
        uguess=Integer.parseInt(editText.getText().toString());
        if(uguess==Rnum){
         textView.setText("correct guess");
        }
        else if(uguess>Rnum)
        {
            textView.setText("Too high");
        }
        else
        {
            textView.setText("Too low");
        }

    }
 }