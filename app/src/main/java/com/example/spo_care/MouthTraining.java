package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MouthTraining extends Activity implements View.OnClickListener{

    ImageButton btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mouth_training);

        btn1 = findViewById(R.id.mouthTrainingVideo_1);
        btn2 = findViewById(R.id.mouthTrainingVideo_2);
        btn3 = findViewById(R.id.mouthTrainingVideo_3);
        btn4 = findViewById(R.id.mouthTrainingVideo_4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mouthTrainingVideo_1:
                Intent video1ViewController = new Intent(getApplicationContext(), VideoViewController.class);
                video1ViewController.putExtra("video","mouthTrainingVideo_1");
                startActivity(video1ViewController);
                break;
            case R.id.mouthTrainingVideo_2:
                Intent video2ViewController = new Intent(getApplicationContext(), VideoViewController.class);
                video2ViewController.putExtra("video","mouthTrainingVideo_2");
                startActivity(video2ViewController);
                break;
            case R.id.mouthTrainingVideo_3:
                Intent video3ViewController = new Intent(getApplicationContext(), VideoViewController.class);
                video3ViewController.putExtra("video","mouthTrainingVideo_3");
                startActivity(video3ViewController);
                break;
            case R.id.mouthTrainingVideo_4:
                Intent video4ViewController = new Intent(getApplicationContext(), VideoViewController.class);
                video4ViewController.putExtra("video","mouthTrainingVideo_4");
                startActivity(video4ViewController);
                break;
        }
    }
}
