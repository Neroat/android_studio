package com.example.testpush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Random;

public class ImageRandomView extends AppCompatActivity {

    int[] list = new int[] {R.drawable.mococo1, R.drawable.mococo2, R.drawable.mococo3, R.drawable.mococo4, R.drawable.mococo5 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_image_random_view);

        ImageView iv = findViewById(R.id.imageView);
        Random rn = new Random();
        Button chbtn = findViewById(R.id.changebtn);
        Button backbtn = findViewById(R.id.backbtn);

        chbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImageResource(list[rn.nextInt(list.length)]);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, LoginInputActivity.class); //LoginInputActivity자리에 만든거 넣으면 됨 :)
                startActivity(intent);
                finish();
            }
        });


    }
    public ImageRandomView()
    {
        super();
    }
    private ImageRandomView activity;
}