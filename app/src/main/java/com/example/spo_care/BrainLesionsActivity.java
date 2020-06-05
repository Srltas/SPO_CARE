package com.example.spo_care;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BrainLesionsActivity extends Activity implements View.OnClickListener {

    private ImageView characteristic, precautions, tip, visit;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.brain_lesions);

        characteristic = findViewById(R.id.speak_brain_lesions_characteristic);
        precautions = findViewById(R.id.speak_brain_lesions_precautions);
        tip = findViewById(R.id.speak_brain_lesions_tip);
        visit = findViewById(R.id.speak_brain_lesions_visit);

        visit.setOnClickListener(this);
        tip.setOnClickListener(this);
        precautions.setOnClickListener(this);
        characteristic.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.speak_brain_lesions_characteristic:
                playMedia(R.raw.sound_brain_lesions_characteristic);
                break;
            case R.id.speak_brain_lesions_precautions:
                playMedia(R.raw.sound_brain_lesions_precautions);
                break;
            case R.id.speak_brain_lesions_tip:
                playMedia(R.raw.sound_brain_lesions_tip);
                break;
            case R.id.speak_brain_lesions_visit:
                playMedia(R.raw.sound_brain_lesions_visit);
                break;
        }
    }

    public void playMedia(int id){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        mediaPlayer = MediaPlayer.create(BrainLesionsActivity.this,id);
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
