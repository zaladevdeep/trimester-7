package com.example.practical_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    Button b1,b2;

    public void setup(){
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        b1.setOnClickListener(v -> {
            checkpermimg();
        });
        b2.setOnClickListener(v -> {
            checkpermvdo();
        });
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == getPackageManager().PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//                start();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void checkpermimg() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == getPackageManager().PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//            b1.setback;
            startCamera();
        } else {
            requestCameraPermission();
        }
    }

    public void checkpermvdo() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == getPackageManager().PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//            b1.setback;
            startVideo();
        } else {
            requestCameraPermission();
        }
    }

    private void startCamera() {
        //TODO: Start Camera
        Toast.makeText(this, "Camera Started", Toast.LENGTH_SHORT).show();
        Intent p = new Intent(this, ImageCap.class);
        startActivity(p);
    }

    private void startVideo() {
        //TODO: Start Video
        Toast.makeText(this, "Video Started", Toast.LENGTH_SHORT).show();
        Intent p1 = new Intent(this, VideoCap.class);
        startActivity(p1);
    }

    public void requestCameraPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)) {
            Snackbar.make(findViewById(R.id.btn1), "Permission is required to use Camera", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", v -> ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 100))
                    .show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 100);
        }
//        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 100);
    }
}