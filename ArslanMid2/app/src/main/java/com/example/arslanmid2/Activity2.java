package com.example.arslanmid2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Intent intent;
    EditText editText;
    RadioGroup radioGroup;
    SQLiteDatabase db;
    Book book;
    ArrayList<Book> arrayList = new ArrayList<Book>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        db = openOrCreateDatabase("BooksDB",MODE_PRIVATE,null);
        db.execSQL("create table if not exists Book(id integer primary key autoincrement," +
                " book_name varchar, author varchar, year varchar);");

        ContentValues cv = new ContentValues();
        cv.put("book_name","LostTime");
        cv.put("author","Arslan");
        cv.put("year","2020");
        db.insert("Book",null,cv);


        cv.put("book_name","LostTime2");
        cv.put("author","jabbar");
        cv.put("year","2021");
        db.insert("Book",null,cv);


        cv.put("book_name","LostTime4");
        cv.put("author","haseeb");
        cv.put("year","2022");
        db.insert("Book",null,cv);


        cv.put("book_name","LostTime5");
        cv.put("author","nisar");
        cv.put("year","2023");
        db.insert("Book",null,cv);



    }





    public void search(View v)
    {
        editText = (EditText) findViewById(R.id.edit_bookName);
        radioGroup = (RadioGroup) findViewById(R.id.radio_grp);

        int id = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(id);
        db = openOrCreateDatabase("BooksDB",MODE_PRIVATE,null);
        Cursor cr = db.rawQuery("select * from Book where "+radioButton.getTag()+" like '"+editText.getText().toString()+"';",null);

        if (cr.getCount()>0)
        {
            cr.moveToFirst();
            do {
                book = new Book(cr.getString(1),cr.getString(2),cr.getString(3));
                arrayList.add(book);
            }while (cr.moveToNext());


            intent = new Intent(this,Activity3.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("bookList",(Serializable) arrayList);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"There is no Book with this name",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        sharedPreferences = getSharedPreferences("CMSLOGIN",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (item.getItemId() == R.id.logout)
        {
            editor.putBoolean("isLogin",false).apply();
            editor.commit();
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}