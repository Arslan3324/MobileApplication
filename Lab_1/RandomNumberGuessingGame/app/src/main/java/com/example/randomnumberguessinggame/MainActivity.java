package com.example.randomnumberguessinggame;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random;
    int NumberToGuess;
    int GuessNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        NumberToGuess = random.nextInt(1000);
        Log.d(TAG, "Random Number: "+NumberToGuess);
    }




    public void validate(View view)
    {
        TextView guessText = findViewById(R.id.guesstxt);
        EditText boxtext = findViewById(R.id.guessbox);
        guessText.setText("Guess a number brtween 1 to 1000");
        GuessNumber = Integer.parseInt(boxtext.getText().toString());

        if(GuessNumber == NumberToGuess)
        {
            guessText.setText("You Won! You Guess Correct");

        }
        else if(GuessNumber<NumberToGuess)
        {
            guessText.setText("Your guess is too low");
        }
        else if(GuessNumber>NumberToGuess)
        {
            guessText.setText("Your Guess is too High");
        }

    }
}