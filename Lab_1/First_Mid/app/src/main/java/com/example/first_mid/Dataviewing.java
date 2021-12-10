package com.example.first_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Dataviewing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataviewing);

        Intent intent=getIntent();
        String price=intent.getStringExtra("price");
        String payment=intent.getStringExtra("payment");
        String longterm=intent.getStringExtra("longterm");
//
        TextView price_view=findViewById(R.id.price);
        TextView payment_v=findViewById(R.id.putdown);

                TextView longterm_view=findViewById(R.id.longterm);
        price_view.setText(price);

        payment_v.setText(payment);
        longterm_view.setText("Loan Term is "+longterm+" years");

        Log.i("key",payment);

        TextView tax_view=findViewById(R.id.taxedamt);
        float tax=Float.parseFloat(price)*0.07f;
        tax_view.setText(""+tax);
        TextView cost_view =findViewById(R.id.cost);
        float cost=tax+Float.parseFloat(price);

        cost_view.setText(""+cost);
        TextView brow_amt=findViewById(R.id.borrrowamt);

        float brw=cost-Float.parseFloat(payment);
        brow_amt.setText(""+brw);

        float intamt= (float) (brw*0.09);
        TextView intreset_view=findViewById(R.id.interest);
        intreset_view.setText(""+intamt);

        float MP=brw/(Float.parseFloat(longterm)*12);
        TextView mp=findViewById(R.id.monthly);
        mp.setText(""+MP);

    }
    public void back(View view){
    finish();

    }

}