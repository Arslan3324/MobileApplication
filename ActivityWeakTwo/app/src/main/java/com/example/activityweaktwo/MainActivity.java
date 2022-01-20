package com.example.activityweaktwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText guessBox;
    Button val;
    TextView output;
    TextView actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessBox = findViewById(R.id.guessbox);
        val = findViewById(R.id.button2);
        output = findViewById(R.id.textView);
        int numberOfTries = 0;
        Random rand = new Random();
        int numberToGuess = rand.nextInt(1000);
        actual = findViewById(R.id.textView3);


        val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actual.setText(numberToGuess+"");
                int guess = Integer.parseInt(guessBox.getText().toString());
                if(guess == numberToGuess){
                    output.setText("Correct");
                }
                else if(guess < numberToGuess){
                    output.setText("Your Guess is too low");
                }
                else if(guess > numberOfTries){
                    output.setText("Your guess is too high");
                }
            }
        });

    }


}