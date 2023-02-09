package com.example.practical_9;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoCap extends AppCompatActivity {

    VideoView vv;
    Button b1;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_cap);

        vv = findViewById(R.id.videoView);
        b1 = findViewById(R.id.button2);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                vv.setVideoURI(result.getData().getData());
                vv.start();
            }
            else if (result.getResultCode() == RESULT_CANCELED) {
                Toast.makeText(this, "Video Cancelled", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Video Failed", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(v -> {
            Toast.makeText(this, "Video Started", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            activityResultLauncher.launch(i);
        });
    }
}