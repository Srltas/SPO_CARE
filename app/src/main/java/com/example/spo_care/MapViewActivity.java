package com.example.spo_care;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MapViewActivity extends Activity implements View.OnClickListener {

    //TODO 맵 레이아웃 테스트용 실제 개발은 레이아웃이 잡힌 후에 시작할 예정

    MapPOIItem marker = new MapPOIItem();
    MapPoint MARKER_POINT = MapPoint.mapPointWithCONGCoord(36.798755, 127.075768);
    MapView mapView = new MapView(this);

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
        setContentView(R.layout.map_view);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

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

    private void showLocation(double xCONG, double yCONG, String name){
        if (marker != null){
            mapView.removePOIItem(marker);
        }

        MARKER_POINT = MapPoint.mapPointWithCONGCoord(xCONG,yCONG);

        marker.setItemName(name);
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);

        mapView.addPOIItem(marker);
    }
    @Override
    public void onClick(View view){
        if(view == seoul){
            showLocation(37.577715, 126.999662, "서울대학교치과병원");
        }
        if(view == wonju){
            showLocation(37.765180,128.869523,"강릉원주대학교치과병원");
        }
        if(view == dankook1){
            showLocation(37.321945,127.124881,"단국대학교죽전치과병원");
        }
        if(view == jeonnam){
            showLocation(35.172352,126.900654,"전남대학교치과병원");
        }
        if(view == kyungpook){
            showLocation(35.864233,128.601639,"경북대학교치과병원");
        }
        if(view == busan){
            showLocation(35.326803,129.007270,"부산대치과병원");
        }
        if(view == gachon){
            showLocation(37.452095,126.709208,"가천대학교길병원");
        }
        if(view == jeonbuk){
            showLocation(35.846935, 127.139380, "전북대학교치과병원");
        }
        if(view == jeju){
            showLocation(33.467087,126.545503,"제주대학교치과병원");
        }
        if(view == dankook2){
            showLocation(36.837844,127.171838,"단국대학교치과대학부속병원");
        }
    }
}
