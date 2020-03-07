package com.aaa.myusingvideo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.aaa.myusingvideo.activities.MainActivity;
import com.aaa.myusingvideo.activities.MusicActivity;
import com.aaa.myusingvideo.activities.WebVideoActivity;

public class StartActivity  extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void StartVideoUrl(View view) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void StartYoutubeVideo(View view) {
        Intent intent = new Intent(StartActivity.this, WebVideoActivity.class);
        startActivity(intent);
    }

    public void StartMp3(View view) {
        Intent intent = new Intent(StartActivity.this, MusicActivity.class);
        startActivity(intent);
    }
}
