package com.example.practical_7;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> resultlaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        TextView txt = findViewById(R.id.textView);
                        Intent intent = result.getData();
                        String value = intent.getStringExtra("result");
                        Log.d("Return",value);
                        txt.setText(value);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText b = findViewById(R.id.edtText);
        EditText c = findViewById(R.id.edttxt);

        Button z = findViewById(R.id.btn1);

        z.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            i.putExtra("a", b.getText().toString());
            i.putExtra("b", c.getText().toString());
//            startActivityForResult(i, 1);
            resultlaunch.launch(i);
        });
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                TextView a = (TextView) findViewById(R.id.textView);
//                a.setText(result);
//            }
//        }
//    }

}