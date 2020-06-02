package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MouthTraining extends Activity {

    ImageButton btn1;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mouth_training);

        btn1 = findViewById(R.id.thumbnail_1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent VideoViewIntent = new Intent(getApplicationContext(), VideoViewController.class);
                startActivity(VideoViewIntent);
            }
        });
    }
}
