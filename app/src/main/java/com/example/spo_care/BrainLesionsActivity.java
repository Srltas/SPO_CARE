package com.example.spo_care;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BrainLesionsActivity extends Activity implements View.OnClickListener {

    private ImageView characteristic;
    private MediaPlayer mediaPlayer;

    private boolean checkMedia = true;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.brain_lesions);

        characteristic = findViewById(R.id.icon_brain_lesions_characteristic);

        characteristic.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.icon_brain_lesions_characteristic:
                playMedia(R.raw.sound_brain_lesions_characteristic);
        }
    }

    public void playMedia(int id){
        if(checkMedia){
            checkMedia = false;
            mediaPlayer = MediaPlayer.create(BrainLesionsActivity.this,id);
            mediaPlayer.start();
        }else{
            checkMedia = true;
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }
}
