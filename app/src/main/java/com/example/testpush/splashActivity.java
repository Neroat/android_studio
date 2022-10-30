package com.example.testpush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity = this;
        move(2);
    }
    public splashActivity() {super();}
    private splashActivity activity;
    private void move(int sec)
    {
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(activity, LoginInputActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000*sec);
    }
}