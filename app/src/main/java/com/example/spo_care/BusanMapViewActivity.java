package com.example.spo_care;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class BusanMapViewActivity extends Activity implements View.OnClickListener, MapView.MapViewEventListener, MapView.POIItemEventListener{
    MapPOIItem marker;
    MapView mapView;
    MapPoint markerPoint = MapPoint.mapPointWithGeoCoord(35.326803, 129.007270);

    private static final String TAG = "BusanMapViewActivity";

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.);
        mapView = new MapView(this);

        mapViewContainer.addView(mapView);
    }
}
