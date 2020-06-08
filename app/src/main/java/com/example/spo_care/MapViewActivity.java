package com.example.spo_care;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import net.daum.android.map.MapViewEventListener;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MapViewActivity extends Activity implements View.OnClickListener, MapView.MapViewEventListener, MapView.POIItemEventListener {

    //TODO 맵 레이아웃 테스트용 실제 개발은 레이아웃이 잡힌 후에 시작할 예정

    MapPOIItem marker;
    MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(36.798755, 127.075768);

    MapPoint seoul = MapPoint.mapPointWithGeoCoord(37.577715, 126.999662);
    MapPoint wonju = MapPoint.mapPointWithGeoCoord(37.765180,128.869523);
    MapPoint dankook1 = MapPoint.mapPointWithGeoCoord(37.321945, 127.124881);

    MapPoint jeonnam = MapPoint.mapPointWithGeoCoord(35.172352 ,126.900654);
    MapPoint kyungpook = MapPoint.mapPointWithGeoCoord(35.864233, 128.601639);
    MapPoint busan = MapPoint.mapPointWithGeoCoord(35.326803, 129.007270);

    MapPoint gachon = MapPoint.mapPointWithGeoCoord(37.452095, 126.709208);
    MapPoint jeonbuk = MapPoint.mapPointWithGeoCoord(35.846935, 127.139380);
    MapPoint jeju = MapPoint.mapPointWithGeoCoord(33.467087,126.545503);

    MapPoint dankook2 = MapPoint.mapPointWithGeoCoord(36.837844,127.171838);


    MapView mapView;

    Button btnSeoul;
    Button btnWonju;
    Button btnDankook1;
    Button btnJeonnam;
    Button btnKyungpook;
    Button btnBusan;
    Button btnGachon;
    Button btnJeonbuk;
    Button btnJeju;
    Button btnDankook2;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.map_view);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapView = new MapView(this);

        mapViewContainer.addView(mapView);

        btnSeoul = (Button) findViewById(R.id.btnSeoul);
        btnWonju = (Button) findViewById(R.id.btnWonju);
        btnDankook1 = (Button) findViewById(R.id.btnDankook1);
        btnJeonnam = (Button) findViewById(R.id.btnJeonnam);
        btnKyungpook = (Button) findViewById(R.id.btnKyungpook);
        btnBusan = (Button) findViewById(R.id.btnBusan);
        btnGachon = (Button) findViewById(R.id.btnGachon);
        btnJeonbuk = (Button) findViewById(R.id.btnJeonbuk);
        btnJeju = (Button) findViewById(R.id.btnJeju);
        btnDankook2 = (Button) findViewById(R.id.btnDankook2);


        marker = new MapPOIItem();
        marker.setItemName("선문대학교 아산캠퍼스");
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);

        mapView.setMapCenterPoint(MARKER_POINT, true);
    }

    private void showLocation(double xCONG, double yCONG, String name){
        if (marker != null){
            mapView.removePOIItem(marker);
        }

        MARKER_POINT = MapPoint.mapPointWithGeoCoord(xCONG,yCONG);

        marker.setItemName(name);
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);

        mapView.addPOIItem(marker);

        mapView.setMapCenterPoint(MARKER_POINT, true);
    }
    @Override
    public void onClick(View view){
        if(view == btnSeoul){
            showLocation(37.577715, 126.999662, "서울대학교치과병원");
        }
        if(view == btnWonju){
            showLocation(37.765180,128.869523,"강릉원주대학교치과병원");
        }
        if(view == btnDankook1){
            showLocation(37.321945,127.124881,"단국대학교죽전치과병원");
        }
        if(view == btnJeonnam){
            showLocation(35.172352,126.900654,"전남대학교치과병원");
        }
        if(view == btnKyungpook){
            showLocation(35.864233,128.601639,"경북대학교치과병원");
        }
        if(view == btnBusan){
            showLocation(35.326803,129.007270,"부산대치과병원");
        }
        if(view == btnGachon){
            showLocation(37.452095,126.709208,"가천대학교길병원");
        }
        if(view == btnJeonbuk){
            showLocation(35.846935, 127.139380, "전북대학교치과병원");
        }
        if(view == btnJeju){
            showLocation(33.467087,126.545503,"제주대학교치과병원");
        }
        if(view == btnDankook2){
            showLocation(36.837844,127.171838,"단국대학교치과대학부속병원");
        }
    }

    @Override
    public void onMapViewInitialized(MapView mapView){

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }




    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {
        Toast.makeText(this, "Clicked " + mapPOIItem.getItemName() + " Callout Balloon", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }
}

