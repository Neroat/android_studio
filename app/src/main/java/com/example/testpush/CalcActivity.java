package com.example.testpush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    //xml파일 내에서 각 위젯들 선언
    EditText memory_susik, cal_result;
    Button add,sub, multi,div,remainder,del,plus_minus,clear;
    Button result;

    //변수 선언
    String history = "";
    String firstNum = "";
    String secondNum = "";

    // 사칙연산을 숫자로 변환
    int type;
    int ADD = 0;
    int SUB = 1;
    int MUL = 2;
    int DIV = 3;
    int REMAINDER = 4;

    //입력된 값, 이전값
    double first_double;
    double second_double;

    // 테스트용
   /*    소수점을 구현할 추가개발을 위해 int는 사용금지
    int i1;
    int i2;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        //버튼 변수를 xml의 해당 버튼에 상속시켜줌 ( 꼭 Button example = find~~이런식으로 쓸 의무x,    가식성이 좋아짐)
        memory_susik = findViewById(R.id.memory_susik);
        cal_result = findViewById(R.id.cal_result);
        cal_result.setText("");
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        multi = findViewById(R.id.btn_multi);
        div = findViewById(R.id.btn_div);
        remainder = findViewById(R.id.btn_remainder);
        del = findViewById(R.id.btn_del);
        plus_minus = findViewById(R.id.btn_plus_minus);
        clear = findViewById(R.id.btn_clear);
        result = findViewById(R.id.btn_result);

        //Button 선언시 항상썻던 setOnClickListener를 미리 선언할수있다. ( 가식성에도 좋고, 안헷갈리고 좋고, 계산기 어플처럼 기능을 [한묶음]으로 해야할때 좋을듯함)
        //또한 매 Button마다 setOnClickListener를 안해도되어 메모리도 덜 잡아먹는다고 인터넷에 서술되어있다.
        add.setOnClickListener(testListener);
        sub.setOnClickListener(testListener);
        multi.setOnClickListener(testListener);
        div.setOnClickListener(testListener);
        remainder.setOnClickListener(testListener);
        result.setOnClickListener(testListener);
        del.setOnClickListener(testListener);
        plus_minus.setOnClickListener(testListener);



        //초기화
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory_susik.setText("");
                cal_result.setText("");
                first_double = second_double = 0;
                history = firstNum = secondNum = "";
            }
        });
    }

    public void onClick (View v)
    {
        switch(v.getId()){
            case R.id.btn0 :
                if(cal_result.getText().toString().equals("") || cal_result.getText().toString()==null)
                    break;
                cal_result.setText(cal_result.getText().toString() + 0);
                break;
            case R.id.btn1 :
                cal_result.setText(cal_result.getText().toString() + 1);
                break;
            case R.id.btn2 :
                cal_result.setText(cal_result.getText().toString() + 2);
                break;
            case R.id.btn3 :
                cal_result.setText(cal_result.getText().toString() + 3);
                break;
            case R.id.btn4 :
                cal_result.setText(cal_result.getText().toString() + 4);
                break;
            case R.id.btn5 :
                cal_result.setText(cal_result.getText().toString() + 5);
                break;
            case R.id.btn6 :
                cal_result.setText(cal_result.getText().toString() + 6);
                break;
            case R.id.btn7 :
                cal_result.setText(cal_result.getText().toString() + 7);
                break;
            case R.id.btn8 :
                cal_result.setText(cal_result.getText().toString() + 8);
                break;
            case R.id.btn9 :
                cal_result.setText(cal_result.getText().toString() + 9);
                break;
            case R.id.btndot :
                //cal_result.setText(cal_result.getText().toString() + ".");            //아직 미구현기능(소수점)
                break;
        }
    }

    Button.OnClickListener testListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_add :
                    firstNum = cal_result.getText().toString();
                    history = cal_result.getText().toString() + " + ";
                    memory_susik.setText(history);
                    cal_result.setText("");
                    type = ADD;
                    break;

                case R.id.btn_sub :
                    firstNum = cal_result.getText().toString();
                    history = cal_result.getText().toString() + " - ";
                    memory_susik.setText(history);
                    cal_result.setText("");
                    type = SUB;
                    break;

                case R.id.btn_multi:
                    firstNum = cal_result.getText().toString();
                    history = cal_result.getText().toString() + " * ";
                    memory_susik.setText(history);
                    cal_result.setText("");
                    type = MUL;
                    break;

                case R.id.btn_div :
                    firstNum = cal_result.getText().toString();
                    history = cal_result.getText().toString() + " / ";
                    memory_susik.setText(history);
                    cal_result.setText("");
                    type = DIV;
                    break;

                case R.id.btn_remainder :
                    firstNum = cal_result.getText().toString();
                    history = cal_result.getText().toString() + " % ";
                    memory_susik.setText(history);
                    cal_result.setText("");
                    type = REMAINDER;
                    break;

                case R.id.btn_del :
                    if(cal_result.getText().length()<=0)
                        break;
                    String del_number = cal_result.getText().toString();
                    cal_result.setText(del_number.substring(0,del_number.length() - 1));
                    break;

                case R.id.btn_plus_minus:
                    if(cal_result.getText().toString().length()<=0)
                    {
                        Toast.makeText(CalcActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    
                    cal_result.setText(""+Integer.parseInt(cal_result.getText().toString()) * -1);
                    Toast.makeText(CalcActivity.this, "플마버튼눌림", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_result :
                    if(cal_result.getText().length()<=0)
                        break;
                    double result = 0;
                    //int testresult = 0;
                    secondNum = cal_result.getText().toString();
                    history = history + cal_result.getText().toString();
                    memory_susik.setText(history);
                    //첫번째 값만 입력하고 =를 누를시 예외처리를 해줘야함(미구현)

                    try
                    {
                        first_double = Double.parseDouble(firstNum);
                        second_double = Double.parseDouble(secondNum);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                    //int형으로 선언시 나눗셈을할시 나머지값이 안보임(기각)
                   // i1 = Integer.parseInt(firstNum);
                    //i2 = Integer.parseInt(secondNum);

                    if(type == ADD) {
                        result = first_double + second_double;
                        cal_result.setText("" + result);
                    } else if (type == SUB) {
                        result = first_double - second_double;
                        cal_result.setText("" + result);
                    }else if (type == MUL) {
                        result = first_double * second_double;
                        cal_result.setText("" + result);
                    }else if (type == DIV) {
                        result = first_double / second_double;
                        cal_result.setText("" + result);
                    }else if (type == REMAINDER) {
                        result = first_double % second_double;
                        cal_result.setText("" + result);
                    }
                    firstNum = cal_result.getText().toString();
                    break;
            }
        }
    };
}