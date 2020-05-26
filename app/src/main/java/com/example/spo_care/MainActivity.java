package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

    ImageView btnMyPage, btnSelfTest, btnTeethCareItem, btnVisualImpairment,
            btnBrainLesions, btnHearingImpairment, btnDisablePeopleDentistry,
            btnTeethBrushTimer, btnMouthTraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMyPage = findViewById(R.id.btnMyPage);
        btnSelfTest = findViewById(R.id.btnSelfTest);
        btnTeethCareItem = findViewById(R.id.btnTeethCareItem);
        btnVisualImpairment = findViewById(R.id.btnVisualImpairment);
        btnTeethBrushTimer = findViewById(R.id.btnTeethBrushTimer);
        btnBrainLesions = findViewById(R.id.btnBrainLesions);
        btnHearingImpairment = findViewById(R.id.btnHearingImpairment);
        btnDisablePeopleDentistry = findViewById(R.id.btnDisablePeopleDentistry);
        btnMouthTraining = findViewById(R.id.btnMouthTraining);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()) {
                    case R.id.btnMyPage:
                        Intent myPageIntent = new Intent(getApplicationContext(), MyPageActivity.class);
                        startActivity(myPageIntent);
                        break;
                    case R.id.btnSelfTest:
                        Intent selfTestIntent = new Intent(getApplicationContext(), SelfTestActivity.class);
                        startActivity(selfTestIntent);
                        break;
                    case R.id.btnTeethCareItem:
                        Intent teethCareItemIntent = new Intent(getApplicationContext(), TeethCareItemActivity.class);
                        startActivity(teethCareItemIntent);
                        break;
                    case R.id.btnVisualImpairment:
                        Intent visualImpairmentIntent = new Intent(getApplicationContext(), VisualImpairmentActivity.class);
                        startActivity(visualImpairmentIntent);
                        break;
                    case R.id.btnTeethBrushTimer:
                        Intent teethBrushTimerIntent = new Intent(getApplicationContext(), TeethBrushTimerActivity.class);
                        startActivity(teethBrushTimerIntent);
                        break;
                    case R.id.btnBrainLesions:
                        Intent brainLesionsIntent = new Intent(getApplicationContext(), BrainLesionsActivity.class);
                        startActivity(brainLesionsIntent);
                        break;
                    case R.id.btnHearingImpairment:
                        Intent hearingImpairmentIntent = new Intent(getApplicationContext(), HearingImpairmentActivity.class);
                        startActivity(hearingImpairmentIntent);
                        break;
                    case R.id.btnDisablePeopleDentistry:
                        Intent disablePeopleDentistryIntent = new Intent(getApplicationContext(), DisablePeopleDentistry.class);
                        startActivity(disablePeopleDentistryIntent);
                        break;
                    case R.id.btnMouthTraining:
                        Intent mouthTrainingIntent = new Intent(getApplicationContext(), MouthTraining.class);
                        startActivity(mouthTrainingIntent);
                        break;
                }
            }
        };
        btnMyPage.setOnClickListener(listener);
        btnTeethCareItem.setOnClickListener(listener);
        btnSelfTest.setOnClickListener(listener);
        btnTeethCareItem.setOnClickListener(listener);
        btnVisualImpairment.setOnClickListener(listener);
        btnTeethBrushTimer.setOnClickListener(listener);
        btnBrainLesions.setOnClickListener(listener);
        btnHearingImpairment.setOnClickListener(listener);
        btnDisablePeopleDentistry.setOnClickListener(listener);
        btnMouthTraining.setOnClickListener(listener);
    }
}