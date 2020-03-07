package com.aaa.myusingvideo.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.aaa.myusingvideo.R;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean noMusic = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

    }

    public void play(View view) {
        ImageView button = findViewById(R.id.media_play);

        if (noMusic) {
            mediaPlayer.start();
            button.setImageResource(R.drawable.ic_pause);
            noMusic = false;
        } else {
            mediaPlayer.pause();
            button.setImageResource(R.drawable.ic_play);
            noMusic = true;
        }
    }

    public void forward(View view) {
    }

    public void rewind(View view) {
    }
}
