package com.aaa.myusingvideo.activities;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.aaa.myusingvideo.R;

import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean noMusic = true;
    SeekBar seekBar;
    ImageView imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);

    }


    public void play(View view) {
        imageButton = findViewById(R.id.media_play);

        if (noMusic) {
            mediaPlayer.start();
            imageButton.setImageResource(R.drawable.ic_pause);
            noMusic = false;
        } else {
            mediaPlayer.pause();
            imageButton.setImageResource(R.drawable.ic_play);
            noMusic = true;
        }
    }

    public void forward(View view) {
        seekBar.setProgress(mediaPlayer.getDuration());
        mediaPlayer.seekTo(mediaPlayer.getDuration());
        mediaPlayer.pause();
        imageButton.setImageResource(R.drawable.ic_play);
    }
    public void rewind(View view) {
        seekBar.setProgress(0);
        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        imageButton.setImageResource(R.drawable.ic_play);
    }
}
