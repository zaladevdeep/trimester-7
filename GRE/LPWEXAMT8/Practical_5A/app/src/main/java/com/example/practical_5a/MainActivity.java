package com.example.practical_5a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnClear, btnDot, btnmod, btnbck;
    private TextView txt;
    private double result;

    public void setinit(){
        btn0 = findViewById(R.id.b0);
        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn5 = findViewById(R.id.b5);
        btn6 = findViewById(R.id.b6);
        btn7 = findViewById(R.id.b7);
        btn8 = findViewById(R.id.b8);
        btn9 = findViewById(R.id.b9);
        btnAdd = findViewById(R.id.bplus);
        btnSub = findViewById(R.id.bsub);
        btnMul = findViewById(R.id.bmul);
        btnDiv = findViewById(R.id.bdiv);
        btnEqual = findViewById(R.id.beql);
        btnClear = findViewById(R.id.bcls);
        btnDot = findViewById(R.id.bdot);
        btnmod = findViewById(R.id.btnmod);
        btnbck = findViewById(R.id.btnback);
        result = 0;

        txt = findViewById(R.id.mainscr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setinit();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+".");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"*");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a = txt.getText().toString();
                    txt.setText(a+"/");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                result = 0;
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = txt.getText().toString();
                DoubleEvaluator ev = new DoubleEvaluator();
                result = ev.evaluate(exp);

                txt.setText(Double.toString(result));
            }
        });
        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = txt.getText().toString();
                txt.setText(a+"%");
            }
        });
        btnbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a ,a1 ;
                a = txt.getText().toString();
                if(!a.equals("")) {
                    a1 = a.substring(0, a.length() - 1);
                    txt.setText(a1);
                }
            }
        });
    }
}