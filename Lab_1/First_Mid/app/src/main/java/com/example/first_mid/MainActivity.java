package com.example.first_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref=getSharedPreferences("user",MODE_PRIVATE);
        String res=pref.getString("email","none");
        if (res.equals("daniyal@gmail.com"))
        {
            Intent intent=new Intent(this,Car_purchase.class);
            startActivity(intent);

        }




    }
    public void login(View view){
    pref=getSharedPreferences("user",MODE_PRIVATE);
    SharedPreferences.Editor editor=pref.edit();
    EditText email=findViewById(R.id.email);
    EditText password=findViewById(R.id.password);

    if(email.getText().toString().equals("daniyal@gmail.com")
    &&password.getText().toString().equals("123"))  {


        editor.putString("email",email.getText().toString());
        editor.putString("pass",password.getText().toString());
        editor.commit();
        Intent intent=new Intent(this,Car_purchase.class);
        startActivity(intent);

    }

     else
        {
            Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
            return;
        }


    }



}