package com.example.testpush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginInputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_input);
        activity = this;
        String[] abc = new String[5];
        Button btn = findViewById(R.id.btn);
        EditText id = findViewById(R.id.id);
        EditText pass = findViewById(R.id.pass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(해당 메세지를 띄울 액티비티, 메세지 내용, LENGTH_LONG >> 5초 || LENGTH_SHORT>>2초).show() << 실행;

                if (id.getText().toString().equals("") || id.getText().toString() == null)
                {
                    Toast.makeText(LoginInputActivity.this, "아이디를 입력하세요.", Toast.LENGTH_LONG).show();
                }

                else if (pass.getText().toString().equals("") || pass.getText().toString() == null)
                {
                    Toast.makeText(LoginInputActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                }

                else
                {
                    Intent i = new Intent(activity, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

    }
    public LoginInputActivity()
    {
        super();
    }
    private LoginInputActivity activity;
}