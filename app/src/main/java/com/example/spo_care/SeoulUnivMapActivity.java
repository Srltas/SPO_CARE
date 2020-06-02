package com.example.spo_care;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class SeoulUnivMapActivity extends Activity {

    //TODO 맵 레이아웃 테스트용 실제 개발은 레이아웃이 잡힌 후에 시작할 예정

    MapPOIItem marker = new MapPOIItem();
    Button seoul;
    Button wonju;
    Button dankook1;
    Button jeonnam;
    Button kyungpook;
    Button busan;
    Button gachon;
    Button jeonbuk;
    Button jeju;
    Button dankook2;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.seoul_univ_map);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        MapPoint MARKER_POINT = MapPoint.mapPointWithCONGCoord(36.798755, 127.075768);

        seoul = (Button) findViewById(R.id.btnSeoul);
        wonju = (Button) findViewById(R.id.btnWonju);
        dankook1 = (Button) findViewById(R.id.btnDankook1);
        jeonnam = (Button) findViewById(R.id.btnJeonnam);
        kyungpook = (Button) findViewById(R.id.btnKyungpook);
        busan = (Button) findViewById(R.id.btnBusan);
        gachon = (Button) findViewById(R.id.btnGachon);
        jeonbuk = (Button) findViewById(R.id.btnJeonbuk);
        jeju = (Button) findViewById(R.id.btnJeju);
        dankook2 = (Button) findViewById(R.id.btnDankook2);


        marker.setItemName("선문대학교 아산캠퍼스");
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);

        mapView.addPOIItem(marker);
    }
}
