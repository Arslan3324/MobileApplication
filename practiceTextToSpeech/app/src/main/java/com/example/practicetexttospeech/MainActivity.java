package com.example.practicetexttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1;
    EditText ed1;
    Button speakbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speakbtn = findViewById(R.id.spkbtn);
        ed1 = findViewById(R.id.txt);
         t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status ==TextToSpeech.SUCCESS)
                {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
         speakbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 speak(v);
             }
         });
    }

    public  void speak(View view)
    {
         String text = ed1.getText().toString();
         t1.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    public void move(View view)
    {
        Intent intent = new Intent(this,SpeakToText.class);
        startActivity(intent);
    }

}