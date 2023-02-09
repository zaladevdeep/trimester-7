package com.example.practical_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

//    private int year, month, day;
//    private Calendar calendar;
    ArrayList<String> state = new ArrayList<String>();
    private Button btn,submit;
    private String username,password,address,gender,age,dob,statef,a,finalage;

//    int sysy,sysm,sysd;

//    LocalDate systemdate = LocalDate.now();
//    LocalDate dobb;

    public void spinerset(){
        Spinner spi = findViewById(R.id.state);
        state.add("Gujarat");
        state.add("Maharashtra");
        state.add("Rajasthan");
        state.add("Madhya Pradesh");
        state.add("Karnataka");
        state.add("Kerala");
        state.add("Tamil Nadu");
        state.add("Andhra Pradesh");
        state.add("Telangana");
        state.add("Uttar Pradesh");
        state.add("Bihar");
        state.add("Jharkhand");
        state.add("West Bengal");
        state.add("Assam");
        state.add("Arunachal Pradesh");
        state.add("Manipur");
        state.add("Meghalaya");
        state.add("Mizoram");
        state.add("Nagaland");
        state.add("Sikkim");
        state.add("Tripura");
        state.add("Jammu and Kashmir");
        state.add("Himachal Pradesh");
        state.add("Punjab");
        state.add("Chandigarh");
        state.add("Haryana");
        state.add("Uttarakhand");
        state.add("Chhattisgarh");
        state.add("Odisha");
        ArrayAdapter<String> adp = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, state);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adp);
    }


    public void dobset(){
//        calendar = Calendar.getInstance();
//        year = calendar.get(Calendar.YEAR);
//        month = calendar.get(Calendar.MONTH);
//        day = calendar.get(Calendar.DAY_OF_MONTH);
//        sysy = year;
//        sysm = month;
//        sysd = day;
//        showDialog(999);
//        showDate(year, month+1, day);

//        int y = sysy - year;
//        int m,d;
//        if((sysm - month)>0){
//            m = sysm - month;
//        }
//        else{
//            y=y-1;
//            m=12-(month-sysm);
//        }
//        if((sysd - day)>0){
//            d = sysd - day;
//        }
//        else {
//            m=m-1;
//            d = 30 - (sysd - day);
//        }

//        showDate(y,m,d);
        Log.d("GAAAY","GAYYY");
        DialogFragment n = new DatePickerMain();
        n.show(getSupportFragmentManager(),"dt");
        Log.d("GAAAY","GAYYY");

    }
//    protected Dialog onCreateDialog(int id){
//        if(id==999){
//            return new DatePickerDialog(this,myDateListener,year,month,day);
//        }
//        return null;
//    }
//    private DatePickerDialog.OnDateSetListener myDateListener = new
//            DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker arg0,
//                                      int arg1, int arg2, int arg3) {
//                    // TODO Auto-generated method stub
//                    // arg1 = year
//                    // arg2 = month
//                    // arg3 = day
//
//                    showDate(arg1, arg2+1, arg3);
//                }
//            };
//    public void showDate(int year, int month, int day) {
//        TextView dt = (TextView) findViewById(R.id.dob1);
//        sysm=month;
//        sysd=day;
//        sysy=year;
//        a = day+"/"+month+"/"+year;
//        dobb=LocalDate.of(year,month,day);
//        calcdate(dobb);
//    }

//public void onDateSet(DatePicker v,int y,int m,int dm){
//        a = dm+"/"+m+"/"+y;
//    }

    public void onsub(){
        TextView txt11 = findViewById(R.id.username);
        TextView txt21 = findViewById(R.id.pass);
        TextView txt31 = findViewById(R.id.add);
        TextView txt41 = findViewById(R.id.age);
//        TextView txt51 = findViewById(R.id.state);

        username = txt11.getText().toString();
        password = txt21.getText().toString();
        address = txt31.getText().toString();
        age = txt41.getText().toString();

        gender="";

        RadioGroup rdgen = (RadioGroup) findViewById(R.id.rdgrp);
        int get = rdgen.getCheckedRadioButtonId();
        if(get!=-1)
        {
            RadioButton rdbtn = (RadioButton) findViewById(get);
            gender = rdbtn.getText().toString();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error");
            builder.setMessage("Not Selected Gender! Try Again");

            builder.setPositiveButton("OK", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }


        Spinner spi2 = findViewById(R.id.state);
        statef = spi2.getSelectedItem().toString();

        TextView txt1= findViewById(R.id.dob1);
        TextView txt2= findViewById(R.id.state1);
        TextView txt3= findViewById(R.id.gen);
        TextView txt4= findViewById(R.id.ag);
        TextView txt5= findViewById(R.id.ad);
        TextView txt6= findViewById(R.id.pas);
        TextView txt7= findViewById(R.id.use);

        txt3.setText(gender); //done
        txt4.setText(finalage); //done
        txt5.setText(address); //done
        txt6.setText(password); //done
        txt7.setText(username); //done
        txt1.setText(a); //date done
        txt2.setText(statef);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn2);
        submit = findViewById(R.id.submit);

        spinerset();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dobset();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onsub();
            }
        });
    }

    public void onDateSet(DatePicker dt, int year, int month, int dayOfMonth) {
        a = dayOfMonth + "/" + (month+1) + "/" + year;
        Button t2 = findViewById(R.id.btn2);

        t2.setText(a);
    }


//    private  void calcdate(LocalDate dobb){
//        LocalDate systemdate = LocalDate.now();
//        dobb = LocalDate.of(year,month,day);
//
//        long days = ChronoUnit.DAYS.between(dobb,systemdate);
//
//        finalage = String.valueOf(days);
//    }
}