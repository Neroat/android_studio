package com.example.testpush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);

                Random rd = new Random();
                String rdText = "가나다라마바사아자차카타파하";
                tv.setText("");
                String show = "";

                for(int i = 0; i<5; i++)
                {
                    char rdC = rdText.charAt(rd.nextInt(rdText.length()));
                    show = show+rdC;
                }
                tv.setText(show);
    }
}