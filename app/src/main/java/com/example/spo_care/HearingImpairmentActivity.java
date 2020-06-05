package com.example.spo_care;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HearingImpairmentActivity extends Activity implements View.OnClickListener {

    private ImageView characteristic, precautions;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.hearing_impairment);

        characteristic = findViewById(R.id.speak_hearing_impairment_characteristic);
        precautions = findViewById(R.id.speak_hearing_impairment_precautions);

        precautions.setOnClickListener(this);
        characteristic.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.speak_hearing_impairment_characteristic:
                playMedia(R.raw.sound_hearing_impairment_characteristic);
                break;
            case R.id.speak_hearing_impairment_precautions:
                playMedia(R.raw.sound_hearing_impairment_precautions);
                break;
        }
    }

    public void playMedia(int id){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        mediaPlayer = MediaPlayer.create(HearingImpairmentActivity.this,id);
        mediaPlayer.start();
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

