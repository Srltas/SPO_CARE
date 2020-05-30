package com.example.spo_care;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapView;

public class MapLayoutTestActivity extends Activity {

    //TODO 맵 레이아웃 테스트용 실제 개발은 레이아웃이 잡힌 후에 시작할 예정

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.map_view);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

    }
}
