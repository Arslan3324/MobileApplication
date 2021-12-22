package com.example.scrimish_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class activity_game extends AppCompatActivity {

    public SharedPreferences pfs;
    TextView tv;
    public int cardPicked=0;
    public int deckCount=0;
    public int fifteen=15;
    public FrameLayout deck5[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tv= findViewById(R.id.label);

        pfs=getSharedPreferences("names",MODE_PRIVATE);
        String player1 = pfs.getString("p1name","null");
        String player2 = pfs.getString("p2name","null");
        tv.setText(player1+" "+player2);
        instantiateFrameLayouts();
    }
    public void instantiateFrameLayouts(){
        //Linear layout at bottom for 5 decks
        LinearLayout decks = findViewById(R.id.decks);
        //each 5 deck is in framlayout with  Image Views
        deck5 = new FrameLayout[5];
        //set framelayout params and other attributes
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        for(int i=0; i<deck5.length;i++){
            deck5[i] = new FrameLayout(this);
            //deck5[i].setTag("deck"+i+1);
            deck5[i].setLayoutParams(params);
            decks.addView(deck5[i]);
        }

    }
    public void selectCard(View v){
        ImageView _ = (ImageView)v;
        if(cardPicked>24 || _.getTag().equals("cover"))
            return;
        //Create ImageView obj
        ImageView imageView = new ImageView(this);
        //set attributes for ImageView made
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(140, 180);
        layoutParams.gravity=Gravity.CENTER;
        layoutParams.setMargins(0,0,0,fifteen);
        fifteen-=10;
        imageView.setLayoutParams(layoutParams);




        //get the imageView clicked
        ImageView im = (ImageView)v;
        Drawable drawable = im.getDrawable();

        //if dra

        //set the same drawable(pic) with dynamic ImageView obj
        imageView.setImageDrawable(drawable);
        deck5[deckCount].addView(imageView);
        cardPicked++;
        if(cardPicked%5==0){
            deckCount++;
            fifteen=15;
        }
        //set cover drawable to the clicked imageView
        Drawable draw = getResources().getDrawable(R.drawable.cover);
        im.setImageDrawable(draw);
        im.setTag("cover");

    }
    public void changeDrawable(View v){
        ImageView imageView = findViewById(R.id.crown);
        Drawable drawable = getResources().getDrawable(R.drawable.cover);
        imageView.setImageDrawable(drawable);
    }
    public void reset(View v){

        Intent intent = new Intent(this, activity_game.class);
        startActivity(intent);
    }
}