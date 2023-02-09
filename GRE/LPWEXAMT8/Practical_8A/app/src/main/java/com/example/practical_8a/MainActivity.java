package com.example.practical_8a;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView t1;
    ArrayList<String> mainlist;
    ArrayList<String> sublist1,sublist2,sublist3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        mainlist = new ArrayList<String>();
//        mainlist.add("BLUE");
//        mainlist.add("GREEN");
//        mainlist.add("RED");
//        mainlist.add("20 FONT");
//        mainlist.add("30 FONT");
//        mainlist.add("10 FONT");
//        mainlist.add("Bahnschrift");
//        mainlist.add("Lucida Console");
//        mainlist.add("Comic Sans MS");

        mainlist.add("Color");
        mainlist.add("Font Size");
        mainlist.add("Font Style");

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,li);
//        l1.setAdapter(arrayAdapter);

        sublist1 = new ArrayList<String>();
        sublist1.add("Blue");
        sublist1.add("Green");
        sublist1.add("Red");

        sublist2 = new ArrayList<String>();
        sublist2.add("10");
        sublist2.add("20");
        sublist2.add("30");

        sublist3 = new ArrayList<String>();
        sublist3.add("Bahnschrift");
        sublist3.add("Lucida Console");
        sublist3.add("Comic Sans MS");

        BasicSpinnerAdapter adp = new BasicSpinnerAdapter(mainlist, sublist1,sublist2,sublist3,this);
        listView.setAdapter(adp);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAGterm", "onItemClick: "+position);
                switch (position){
                    case 0:
                        String qq = adp.returntxt();
                        Log.d("TAGterm", "onItemClick: "+qq);
                        try {
                            t1.setTextColor(Color.parseColor(qq));
                        }
                        catch (Exception e){
                            Log.d("TAGterm", "ERROR: "+e);
                            Toast.makeText(MainActivity.this, "ERROR: "+e, Toast.LENGTH_SHORT).show();
                        }
//                        t1.setTextColor(Color.parseColor(qq));
                        break;
                    case 1:
                        String ww = adp.returntxt();
                        Log.d("TAGterm", "onItemClick: "+ww);
                        try {
                            t1.setTextSize(Float.parseFloat(ww));
                        }
                        catch (Exception e){
                            Log.d("TAGterm", "ERROR: "+e);
                            Toast.makeText(MainActivity.this, "ERROR: "+e, Toast.LENGTH_SHORT).show();
                        }
//                        t1.setTextSize(Float.parseFloat(ww));
                        break;
                    case 2:
                        String ee = adp.returntxt();
                        Log.d("TAGterm", "onItemClick: "+ee);
                        try {
                            Typeface typeface;
                            if(ee.equals("Bahnschrift"))
                                typeface = getResources().getFont(R.font.bahnschrift);
                            else if(ee.equals("Lucida Console"))
                                typeface = getResources().getFont(R.font.lucon);
                            else
                                typeface = getResources().getFont(R.font.comic);
                            t1.setTypeface(typeface);
                        }
                        catch (Exception e){
                            Log.d("TAGterm", "ERROR: "+e);
                            Toast.makeText(MainActivity.this, "ERROR: "+e, Toast.LENGTH_SHORT).show();
                        }
//                        Typeface typeface;
//                        if(ee.equals("Bahnschrift"))
//                            typeface = getResources().getFont(R.font.bahnschrift);
//                        else if(ee.equals("Lucida Console"))
//                            typeface = getResources().getFont(R.font.lucon);
//                        else
//                            typeface = getResources().getFont(R.font.comic);
//                        t1.setTypeface(typeface);
                        break;
                }
            }
        });
    }
}