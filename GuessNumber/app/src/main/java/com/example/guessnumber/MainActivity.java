package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "a";
    Random random;
    int numberToGuess;
    int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Validate(View view)
    {
        TextView mytxt=findViewById(R.id.guesstext);
        TextView trytext=findViewById(R.id.trytext);
        EditText editText = findViewById(R.id.editext);
        random = new Random();
        numberToGuess = random.nextInt(1000);
        mytxt.setText("Guess a Number Between 1 and 1000");
        guess = Integer.parseInt(editText.getText().toString());
        trytext.setText(""+guess);
        if(guess ==numberToGuess)
        {
            mytxt.setText("You Guessed and Win");
        }
        else if(guess<numberToGuess)
        {
            mytxt.setText("Your guess is low");
        }
        else if(guess>numberToGuess)
        {
            mytxt.setText("Your guess is high");
        }


    }

}