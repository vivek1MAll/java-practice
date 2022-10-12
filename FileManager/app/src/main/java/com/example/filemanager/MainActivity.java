  package com.example.filemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

  public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    AudioManager audioManager;
    public void play(View view){
        player.start();
        Log.i("massage","the start is executed");
    }
      public void stop(View view){
          player.stop();
          Log.i("massage","stop is executed");
      }
      public void pause(View view){
          player.pause();
          Log.i("massage","the player is stop");
      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player=MediaPlayer.create(this,R.raw.iksupna);

        audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVol=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);



        SeekBar seekBar=findViewById(R.id.seekbar);
        seekBar.setMax(maxVol);
        seekBar.setProgress(curVol);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("mass","seek bar is active");
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}