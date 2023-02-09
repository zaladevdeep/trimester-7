package com.example.practical_5b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondact);

        Bundle et = getIntent().getExtras();
        String a = et.getString("name");

        TextView txt = findViewById(R.id.txt);
        txt.setText(txt.getText().toString()+"  "+a);
    }
}