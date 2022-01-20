package com.example.database1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("NAMES",MODE_PRIVATE,null);
        query = "CREATE TABLE IF NOT EXISTS USERS(UserName TEXT,Surname Text)";
        db.execSQL(query);

    }

    public void sumia(View view)
    {
        EditText name = findViewById(R.id.name);
        EditText sname = findViewById(R.id.surname);

        String NameOne = name.getText().toString();
        String SurnameOne = sname.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put("UserName",NameOne);
        cv.put("Surname",SurnameOne);
        db.insert("USERS",null,cv);

        Cursor cursor=db.rawQuery("SELECT * FROM USERS",null);
        cursor.moveToFirst();
        //Cursor pointing specific location agy pechy move krwa k next row prev row
        while(cursor.moveToNext()){
            String Uname=cursor.getString(0);
            String SName=cursor.getString(1);
            Toast.makeText(this,"Username: "+Uname+" "+SName,Toast.LENGTH_SHORT).show();
            Log.d("Count:"," "+cursor.getCount());
        }



    }
}