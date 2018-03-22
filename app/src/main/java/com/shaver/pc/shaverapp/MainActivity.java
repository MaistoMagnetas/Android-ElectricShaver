package com.shaver.pc.shaverapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay;
    private MediaPlayer mediaPlayer;
    private ImageView imageShaver;
    private AdView myAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = (Button) findViewById(R.id.button);
        imageShaver = (ImageView) findViewById(R.id.shaverImage);
        mediaPlayer = MediaPlayer.create(this, R.raw.shaver_sound_trimmed);

        myAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAdView.loadAd(adRequest);

        buttonPlay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        imageShaver.setImageResource(R.drawable.shaver_on);
                        mediaPlayer.setLooping(true);
                        mediaPlayer.start();
                        return true;
                    case MotionEvent.ACTION_UP:
                        imageShaver.setImageResource(R.drawable.shaver_off);
                        mediaPlayer.pause();
                        return true;
                }
                return false;
            }
        });



    }
}
