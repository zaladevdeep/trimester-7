package com.example.practical_7;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle et = getIntent().getExtras();
        String a = et.getString("a");
        String b = et.getString("b");

        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);

        TextView txt = findViewById(R.id.textView2);
        txt.setText("Added Number is: " + c + " AND " + d);

        Button z = findViewById(R.id.btn2);

        z.setOnClickListener(v -> {
            int res = c + d;
            Intent i = new Intent(MainActivity2.this, MainActivity.class);
            i.putExtra("result", valueOf(res));
            setResult(RESULT_OK, i);
            finish();
        });
    }
}