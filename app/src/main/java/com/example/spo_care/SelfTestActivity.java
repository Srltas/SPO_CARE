package com.example.spo_care;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spo_care.R;

public class SelfTestActivity extends AppCompatActivity {

    TextView periodontalDiseaseTest, cavityTest;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.selftest);

        periodontalDiseaseTest = (TextView) findViewById(R.id.periodontalDiseaseTest);
        cavityTest = (TextView) findViewById(R.id.cavityTest);
    }
}
