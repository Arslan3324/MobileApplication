package com.example.exampractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class NewScreen extends AppCompatActivity {

    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_screen);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        TextView viewById = (TextView) findViewById(R.id.nameView);
        viewById.setText(name);
        checkImg();

    }
    public void checkImg ()
    {
        SharedPreferences preferences = getSharedPreferences("img", Context.MODE_PRIVATE);
        String imagePreferance = preferences.getString("imagePreferance", null);
        if(imagePreferance==null)
        {
            return;
        }
        else
        {
            bitmap = decodeBase64(imagePreferance);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);
        }

    }

    public void imgClick(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA  )== PackageManager.PERMISSION_GRANTED)
        {
            startActivityForResult(intent,200);
        }
        else
        {
//            requestPermissions(new String[]{Manifest.permission.CAMERA},200);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},200);
            }
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200)
        {
            if(resultCode== RESULT_OK)
            {
                bitmap =  (Bitmap) data.getExtras().get("data");
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);

            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this,"Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void saveIt(View view) {
        SharedPreferences preferences = getSharedPreferences("img", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("imagePreferance", encodeTobase64(bitmap));
        editor.apply();


    }
    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        return imageEncoded;
    }
    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}