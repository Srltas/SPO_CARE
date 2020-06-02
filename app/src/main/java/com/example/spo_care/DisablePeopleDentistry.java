package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisablePeopleDentistry extends Activity {

    Button btnMapView;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.disable_people_dentistry);

        btnMapView = findViewById(R.id.btnmapView);

        btnMapView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mapViewIntent = new Intent(getApplicationContext(), MapViewActivity.class);
                startActivity(mapViewIntent);
            }
        });
    }
}
