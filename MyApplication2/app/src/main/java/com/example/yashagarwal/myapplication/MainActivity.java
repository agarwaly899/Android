package com.example.yashagarwal.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaplayer = MediaPlayer.create(this,R.raw.alan);
        Button play=(Button) findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"play",Toast.LENGTH_SHORT).show();
                mediaplayer.start();
            }
        });
        Button pause=(Button) findViewById(R.id.pause_button);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"pause",Toast.LENGTH_SHORT).show();
                mediaplayer.pause();
            }
        });
        Button volume=(Button) findViewById(R.id.volume_button);
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"right volume",Toast.LENGTH_SHORT).show();
                mediaplayer.setVolume((float)0.1,(float)0.9);
            }
        });
        Button reset=(Button) findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"reset",Toast.LENGTH_SHORT).show();
                mediaplayer.reset();
                mediaplayer = MediaPlayer.create(MainActivity.this,R.raw.alan);


            }
        });
    }

}
