package com.example.practical_8a;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class BasicSpinnerAdapter extends BaseAdapter  {

    private ArrayList<String> mSpinnerItem1, mSpinnerItem2, mSpinnerItem3;
    private ArrayList<String> mData;
    private Context mContext;
    Spinner spinner;
    String zz;

    public BasicSpinnerAdapter(ArrayList<String> data, ArrayList<String> spinnerItem1,ArrayList<String> spinnerItem2,ArrayList<String> spinnerItem3, Context context) {
        mData = data;
        mContext = context;
        mSpinnerItem1 = spinnerItem1;
        mSpinnerItem2 = spinnerItem2;
        mSpinnerItem3 = spinnerItem3;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.txtspi, null);
        }

        TextView textView = (TextView) view.findViewById(R.id.row_item_textview);
        spinner = (Spinner) view.findViewById(R.id.row_item_spinner);

        textView.setText(mData.get(position));

        if(position==0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mSpinnerItem1);
            spinner.setAdapter(adapter);
        }
        else if(position==1) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mSpinnerItem2);
            spinner.setAdapter(adapter);
        }
        else if(position==2) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mSpinnerItem3);
            spinner.setAdapter(adapter);
        }

        spinner.setFocusable(false);
        spinner.setFocusableInTouchMode(false);

        textView.setFocusable(false);
        textView.setFocusableInTouchMode(false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zz = parent.getItemAtPosition(position).toString();
                Log.d("TAG", "onItemSelected: "+zz);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public String returntxt(){
        return zz;
    }
}