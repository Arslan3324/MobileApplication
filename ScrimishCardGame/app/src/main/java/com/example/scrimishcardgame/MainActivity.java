package com.example.scrimishcardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Pile pile_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setGameData();
        setImagesOfGame();
    }

    private void setImagesOfGame()
    {
        Card card = pile_1.showTop();

    }

    private void setGameData()
    {
        pile_1 = new Pile(1);
        Card crown = new Card("crown",100,R.drawable.crown);
        Card archer = new Card("archer",10,R.drawable.archer);
        Card shield = new Card("shield",0,R.drawable.sheild);
        Card cover = new Card("cover",0,R.drawable.back_cover);
        Card dagger = new Card("dagger",1,R.drawable.one);
        Card sword = new Card("sword",2,R.drawable.two);
        Card star = new Card("star",3,R.drawable.three);
        Card axe = new Card("axe",4,R.drawable.four);
        Card halberd = new Card("halberd",5,R.drawable.five);
        Card longSword = new Card("longSword",6,R.drawable.six);

        pile_1.addCard(crown);
        pile_1.addCard(dagger);
        pile_1.addCard(sword);
        pile_1.addCard(star);
        pile_1.addCard(axe);




    }

    public void showImg(View view)
    {
        ImageView imageView =  (ImageView) view;
        imageView.setImageResource(pile_1.showTop().picture);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                imageView.setImageResource(R.drawable.back_cover);
            }
        },1500);
    }
}