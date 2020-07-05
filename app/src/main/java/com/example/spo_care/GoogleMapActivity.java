package com.example.spo_care;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends Activity implements OnMapReadyCallback {

    GoogleMap gMap;
    MapFragment mapFrag;
    GroundOverlayOptions videoMark;

    LatLng[] coord = new LatLng[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_map);
        setTitle("google map");

        mapFrag=(MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);



        coord[0] = new LatLng(37.577715, 126.999662);
        coord[1] = new LatLng(37.765180, 128.869523);
        coord[2] = new LatLng(37.321945, 127.124881);
        coord[3] = new LatLng(35.172352, 126.900654);
        coord[4] = new LatLng(35.864233, 128.601639);
        coord[5] = new LatLng(35.326803, 129.007270);
        coord[6] = new LatLng(37.452095, 126.709208);
        coord[7] = new LatLng(35.846935, 127.139380);
        coord[8] = new LatLng(33.467087, 126.545503);
        coord[9] = new LatLng(36.837844, 127.171838);
    }

    @Override
    public void onMapReady(GoogleMap map){
        gMap=map;
        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.798806,127.075789),15));
        gMap.getUiSettings().setZoomControlsEnabled(true);

        for (int i = 0; i<10;i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(coord[i]);
            gMap.addMarker(markerOptions);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"서울대 치과병원");
        menu.add(0,2,0,"강릉원주대 치과병원");
        menu.add(0,3,0,"단국대죽전 치과병원");
        menu.add(0,4,0,"전남대 치과병원");
        menu.add(0,5,0,"경북대 치과병원");
        menu.add(0,6,0,"부산대 치과병원");
        menu.add(0,7,0,"가천대길병원");
        menu.add(0,8,0,"전북대 치과병원");
        menu.add(0,9,0,"제주대 치과병원");
        menu.add(0,10,0,"단국대 치과병원");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case 1:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.577715, 126.999662),15));
                return true;

            case 2:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.765180, 128.869523),15));
                return true;

            case 3:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.321945, 127.124881),15));
                return true;

            case 4:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.172352, 126.900654),15));
                return true;

            case 5:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.864233, 128.601639),15));
                return true;

            case 6:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.326803, 129.007270),15));
                return true;

            case 7:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.452095, 126.709208),15));
                return true;

            case 8:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.846935, 127.139380),15));
                return true;

            case 9:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.467087, 126.545503),15));
                return true;

            case 10:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.837844, 127.171838),15));
                return true;

        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture){

    }
}
