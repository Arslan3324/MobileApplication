package com.example.chocolateapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void  plus(View view)
    {
        TextView number = findViewById(R.id.num);

        int quan = Integer.parseInt(number.getText().toString());

        quan++;

        number.setText(quan+"");


    }

    public void minus(View view)
    {
        TextView number = findViewById(R.id.num);
        int quan = Integer.parseInt(number.getText().toString());
        if(quan>0)
        {
            quan--;
        }

        number.setText(quan+"");

    }

    public void order(View view)
    {
        CheckBox cream = findViewById(R.id.cream);
        CheckBox chocolate = findViewById(R.id.chocolate);
        TextView summary = findViewById(R.id.summary);
        TextView quantity = findViewById(R.id.num);
        int totalQ = Integer.parseInt(quantity.getText().toString());

        int coffe = 4;
        int cre = 1;
        int cho = 2;


        if(cream.isChecked() && chocolate.isChecked())
        {
            int one = (coffe+cre+cho)*totalQ;

            summary.setText("Add Cream? Yes"+"\n"+"Add Chocolate? yes"+"\n"+"Quantity: "+totalQ+"\n"+"Price: "+one);
        }
        else if(cream.isChecked() && !chocolate.isChecked())
        {
            int two = (coffe+cre)*totalQ;;
            summary.setText("Add Cream? Yes"+"\n"+"Add Chocolate? No"+"\n"+"Quantity: "+totalQ+"\n"+"Price: "+two);
        }
        else if(!cream.isChecked() && chocolate.isChecked())
        {
            int three = (coffe+cho)*totalQ;;
            summary.setText("Add Cream? NO"+"\n"+"Add Chocolate? Yes"+"\n"+"Quantity: "+totalQ+"\n"+"Price: "+three);


        }
        else{
            int four = coffe*totalQ;
            summary.setText("Add Cream? NO"+"\n"+"Add Chocolate? No"+"\n"+"Quantity: "+totalQ+"\n"+"Price: "+four);

        }




    }
}