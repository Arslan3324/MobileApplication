package com.example.first_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Car_purchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_purchase);
    }
    public void loan(View view){
        RadioButton radio1=findViewById(R.id.two);
        RadioButton radio2=findViewById(R.id.three);
        RadioButton radio3=findViewById(R.id.four);
        EditText price=findViewById(R.id.price);
        EditText payment=findViewById(R.id.payment);


        String longterm="";
        if(radio1.isChecked())
            longterm="2";
        if(radio2.isChecked())
            longterm="3";
        if(radio3.isChecked())
            longterm="4";

        Intent intent=new Intent(this,Dataviewing.class);
        intent.putExtra("price",price.getText().toString());
        intent.putExtra("payment",payment.getText().toString());
        intent.putExtra("longterm",longterm);

        startActivity(intent);



    }

}