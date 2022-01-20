package com.example.arslanahmed_midone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {


    Integer[] array = {R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.two,R.drawable.two,
            R.drawable.two,R.drawable.two,R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.three,
            R.drawable.four,R.drawable.four,R.drawable.four,R.drawable.four,
            R.drawable.five,R.drawable.five,R.drawable.five,R.drawable.five,
            R.drawable.six,R.drawable.six,R.drawable.six,R.drawable.six,
            R.drawable.seven,R.drawable.seven,R.drawable.seven,R.drawable.seven,R.drawable.eight,R.drawable.eight
            ,R.drawable.eight,R.drawable.eight,R.drawable.nine,R.drawable.nine,R.drawable.nine,R.drawable.nine,
            R.drawable.king,R.drawable.king,R.drawable.king,R.drawable.king,R.drawable.queen,R.drawable.queen,R.drawable.queen,
            R.drawable.queen,R.drawable.jack,R.drawable.jack,R.drawable.jack,R.drawable.jack,
            R.drawable.ace,R.drawable.ace,R.drawable.ace,R.drawable.ace};

    Random rand = new Random();
    boolean UserOnePlay = true;
    boolean UserTwoPlay = false;

    ImageView ImageUserOne;
    ImageView ImageUserTwo;

    TextView U1TotalScore;
    TextView U2TotalScore;
    int scoreOne = 0;
    int scoreTwo =0 ;
    int index1;
    int index2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView Username1 = findViewById(R.id.user1Name);
        TextView Username2 = findViewById(R.id.user2Name);
        SharedPreferences preferences = getSharedPreferences("usernames", Context.MODE_PRIVATE);
        String Uname1 = preferences.getString("user1",null);
        String Uname2 = preferences.getString("user2",null);
        Username1.setText(Uname1+"");
        Username2.setText(Uname2+"");

        index1 = rand.nextInt(48);
        index2 = rand.nextInt(48);
        ImageUserOne = findViewById(R.id.useroneimage);
        ImageUserTwo = findViewById(R.id.usertwoimage);

        ImageUserOne.setImageResource(array[index1]);
        ImageUserTwo.setImageResource(array[index2]);




    }

    public void hitme(View view)
    {
        ImageView ImgUserOne = findViewById(R.id.useroneimage);
        ImageView ImgUserTwo = findViewById(R.id.usertwoimage);


        index1 = rand.nextInt(48);
        index2 = rand.nextInt(48);



        if(UserOnePlay == true )
        {
            Toast.makeText(this,"User One Turn",Toast.LENGTH_LONG).show();
            ImgUserOne.setImageResource(array[index1]);

                scoreOne +=5;
                U1TotalScore = findViewById(R.id.score1);
                U1TotalScore.setText(scoreOne+"");
            UserOnePlay = false;

        }
        else{
            Toast.makeText(this,"User Two Turn",Toast.LENGTH_LONG).show();
            ImgUserTwo.setImageResource(array[index2]);
                scoreTwo +=5;
                U2TotalScore = findViewById(R.id.score2);
                U2TotalScore.setText(scoreOne+"");

            UserOnePlay = true;

        }
/*

        if((index1 >=46 && index1 <= 48) || (index2 >=46 && index2 <= 48) )
        {
            scoreOne +=11;
            scoreTwo +=11;
            U1TotalScore = findViewById(R.id.score1);
            U1TotalScore.setText(scoreOne+"");
            U2TotalScore = findViewById(R.id.score2);
            U2TotalScore.setText(scoreTwo+"");
        }
        else if((index1 >=41 && index1 <= 45) || (index2 >=41 && index2 <= 45))
        {
            scoreOne +=10;
            scoreTwo +=10;
            U1TotalScore = findViewById(R.id.score1);
            U1TotalScore.setText(scoreOne+"");
            U2TotalScore = findViewById(R.id.score2);
            U2TotalScore.setText(scoreTwo+"");
        }
        else if((index1 >=39 && index1 <= 40) || (index2 >=39 && index2 <= 40))
        {
            scoreOne +=10;
            scoreTwo +=10;
            U1TotalScore = findViewById(R.id.score1);
            U1TotalScore.setText(scoreOne+"");
            U2TotalScore = findViewById(R.id.score2);
            U2TotalScore.setText(scoreTwo+"");
        }

        else if((index1 >=39 && index1 <= 40) || (index2 >=39 && index2 <= 40)){

            scoreOne +=9;
            scoreTwo +=9;
            U1TotalScore = findViewById(R.id.score1);
            U1TotalScore.setText(scoreOne+"");
            U2TotalScore = findViewById(R.id.score2);
            U2TotalScore.setText(scoreTwo+"");

        }

*/




    }

    public void stand(View view)
    {
        index1 = rand.nextInt(48);
        index2 = rand.nextInt(48);
        ImageView ImgUserOne = findViewById(R.id.useroneimage);
        ImageView ImgUserTwo = findViewById(R.id.usertwoimage);
        ImgUserOne.setImageResource(array[index1]);
        ImgUserTwo.setImageResource(array[index2]);


    }
}