package com.example.practical_9;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageCap extends AppCompatActivity {

    ImageView iv;
    Button b1;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_cap);

        iv = findViewById(R.id.imageView);
        b1 = findViewById(R.id.button);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Bitmap bm = (Bitmap) result.getData().getExtras().get("data");
                iv.setImageBitmap(bm);
            }
            else if (result.getResultCode() == RESULT_CANCELED) {
                Toast.makeText(this, "Camera Cancelled", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Camera Failed", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(v -> {
            Toast.makeText(this, "Camera Started", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activityResultLauncher.launch(i);
        });
    }
}