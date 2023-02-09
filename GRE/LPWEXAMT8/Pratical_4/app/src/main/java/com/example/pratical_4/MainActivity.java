package com.example.pratical_4;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnadd,btnrem;
    private TextView txt;
//    private String[] country = {"India","Australia","Iran","Iraq"};
    ArrayList<String> country = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = findViewById(R.id.button);
        btnrem = findViewById(R.id.button2);
        txt = findViewById(R.id.edtCity);
        Spinner spi = findViewById(R.id.spinner);


        country.add("India");
        country.add("Australia");
        country.add("Iraq");
        country.add("Iran");
        ArrayAdapter<String> adp = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, country);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adp);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCity = txt.getText().toString();
                if(newCity.length()<=0){}
                else{
                    Toast.makeText(MainActivity.this, "Android", Toast.LENGTH_SHORT).show();
                    adp.add(newCity);
                    adp.notifyDataSetChanged();
                }

            }
        });
        btnrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCity = txt.getText().toString();
                if(newCity.length()<=0){}
                else{
                    adp.remove(newCity);
                    adp.notifyDataSetChanged();
                }

            }
        });
    }
}