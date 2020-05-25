package com.example.spo_care;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnClickListener{

    ImageView btnMyPage, btnSelfTest, btnTeethCareItem, btnVisualImpairment,
            btnBrainLesions, btnHearingImpairment, btnDisablePeopleDentistry,
            btnTeethBrushTimer, btnMouthTraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMyPage = (ImageView) findViewById(R.id.btnMyPage);
        btnSelfTest = (ImageView) findViewById(R.id.btnSelfTest);
        btnTeethCareItem = (ImageView) findViewById(R.id.btnTeethCareItem);
        btnVisualImpairment = (ImageView) findViewById(R.id.btnVisualImpairment);
        btnTeethBrushTimer = (ImageView) findViewById(R.id.btnTeethBrushTimer);
        btnBrainLesions = (ImageView) findViewById(R.id.btnBrainLesions);
        btnHearingImpairment = (ImageView) findViewById(R.id.btnHearingImpairment);
        btnDisablePeopleDentistry = (ImageView) findViewById(R.id.btnDisablePeopleDentistry);
        btnMouthTraining = (ImageView) findViewById(R.id.btnMouthTraining);

        btnTeethCareItem.setOnClickListener(this);
        btnSelfTest.setOnClickListener(this);
        btnTeethCareItem.setOnClickListener(this);
        btnVisualImpairment.setOnClickListener(this);
        btnTeethBrushTimer.setOnClickListener(this);
        btnBrainLesions.setOnClickListener(this);
        btnHearingImpairment.setOnClickListener(this);
        btnDisablePeopleDentistry.setOnClickListener(this);
        btnMouthTraining.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if(view == btnMyPage){
            //아직 없음
        }
        if(view == btnSelfTest){
            //startActivity(new Intent(this, selfTestActivity.class));
        }
        if(view == btnTeethCareItem){

        }
        if(view == btnVisualImpairment){

        }
        if(view == btnTeethBrushTimer){

        }
        if(view == btnBrainLesions){

        }
        if(view == btnHearingImpairment){

        }
        if(view == btnDisablePeopleDentistry){

        }
        if(view == btnMouthTraining){

        }

    }
}