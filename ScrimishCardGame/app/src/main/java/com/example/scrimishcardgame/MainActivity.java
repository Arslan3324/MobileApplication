package com.example.scrimishcardgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Pile[] piles = new Pile[10];
    Pile pile_0;
    Pile pile_1;
    Pile pile_2;
    Pile pile_3;
    Pile pile_4;
    Pile pile_5;
    Pile pile_6;
    Pile pile_7;
    Pile pile_8;
    Pile pile_9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setGameData();
        setImagesOfGame();
        View.OnLongClickListener attack = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String s = v.getTag().toString();
                Integer index = Integer.parseInt(s);
                piles[index].removeTop();

                Toast.makeText(getApplicationContext(), "Attack", Toast.LENGTH_LONG).show();
                return true;
            }
        };
        findViewById(R.id.imageView).setOnLongClickListener(attack);
        findViewById(R.id.imageView2).setOnLongClickListener(attack);
        findViewById(R.id.imageView3).setOnLongClickListener(attack);
        findViewById(R.id.imageView3).setOnLongClickListener(attack);
        findViewById(R.id.imageView4).setOnLongClickListener(attack);
        findViewById(R.id.imageView5).setOnLongClickListener(attack);
        findViewById(R.id.imageView6).setOnLongClickListener(attack);
        findViewById(R.id.imageView7).setOnLongClickListener(attack);
        findViewById(R.id.imageView8).setOnLongClickListener(attack);
        findViewById(R.id.imageView9).setOnLongClickListener(attack);
        findViewById(R.id.imageView10).setOnLongClickListener(attack);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_1,menu);
    }
    private void setImagesOfGame()
    {
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getTitle() == "Attack")
        {
        }
        return  true;
    }

    private void setGameData()
    {

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


        for (int i=0; i<10; i++)
        {
            piles[i] = new Pile(i);
            piles[i].addCard(crown);
            piles[i].addCard(dagger);
            piles[i].addCard(sword);
            piles[i].addCard(star);
            piles[i].addCard(axe);



        }
//        pile_0 = new Pile(0);
//        pile_0.addCard(crown);
//        pile_0.addCard(dagger);
//        pile_0.addCard(sword);
//        pile_0.addCard(star);
//        pile_0.addCard(axe);


    }

    public void showImg(View view)
    {
        String s = view.getTag().toString();
        Integer index = Integer.parseInt(s);
        ImageView imageView =  (ImageView) view;
        imageView.setImageResource(piles[index].showTop().picture);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                imageView.setImageResource(R.drawable.back_cover);
            }
        },1500);
    }
}