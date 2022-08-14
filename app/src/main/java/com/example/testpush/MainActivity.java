package com.example.testpush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*    앱실행시 마다 저장된 문자열중 5개 무작위 문자 출력
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

         */

        TextView tv = findViewById(R.id.viewTxt);
        EditText et = findViewById(R.id.editTxt);
        Button btn = findViewById(R.id.changeBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = et.getText().toString();
                tv.setText(display);
            }
        });
    }
}