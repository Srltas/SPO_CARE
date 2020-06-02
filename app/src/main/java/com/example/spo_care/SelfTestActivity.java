package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SelfTestActivity extends Activity {

    ImageView periodontalDiseaseTest, cavityTest;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.selftest);

        cavityTest = findViewById(R.id.cavityTest);
        periodontalDiseaseTest = findViewById(R.id.periodontalDiseaseTest);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch(view.getId()){
                    case R.id.cavityTest:
                        Intent cavityTestIntent = new Intent(getApplicationContext(), SelfTestCavityActivity.class);
                        startActivity(cavityTestIntent);
                        break;
                    case R.id.periodontalDiseaseTest:
                        Intent periodontalDiseaseTestIntent = new Intent(getApplicationContext(), SelfTestPeriodontalDiseaseActivity.class);
                        startActivity(periodontalDiseaseTestIntent);
                        break;
                }
            }
        };
        cavityTest.setOnClickListener(listener);
        periodontalDiseaseTest.setOnClickListener(listener);
    }
}
