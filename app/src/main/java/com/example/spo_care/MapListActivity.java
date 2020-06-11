package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.daum.mf.map.api.MapView;

public class MapListActivity extends Activity implements View.OnClickListener {

    Button btnSeoul, btnWonju, btnDankook1, btnJeonnam, btnBusan, btnKyungpook, btnGachon, btnJeonbuk, btnJeju, btnDankook2;

    @Override
    protected void onCreate(Bundle sadInstanceState) {
        super.onCreate(sadInstanceState);
        setContentView(R.layout.map_list);

        btnSeoul = (Button) findViewById(R.id.btnSeoul);
        btnWonju = (Button) findViewById(R.id.btnWonju);
        btnDankook1 = (Button) findViewById(R.id.btnDankook1);
        btnJeonnam = (Button) findViewById(R.id.btnJeonnam);
        btnBusan = (Button) findViewById(R.id.btnBusan);
        btnKyungpook = (Button) findViewById(R.id.btnKyungpook);
        btnGachon = (Button) findViewById(R.id.btnGachon);
        btnJeonbuk = (Button) findViewById(R.id.btnJeonbuk);
        btnJeju = (Button) findViewById(R.id.btnJeju);
        btnDankook2 = (Button) findViewById(R.id.btnDankook2);
    }

    @Override
    public void onClick(View view){
        if(view == btnSeoul){
            startActivity(new Intent(this, SeoulMapViewActivity.class));
        }
        if(view == btnWonju){
            startActivity(new Intent(this, WonjuMapViewActivity.class));
        }
        if(view == btnDankook1){
            startActivity(new Intent(this, DankookMapViewActivity.class));
        }
        if(view == btnJeonnam){
            startActivity(new Intent(this, JeonnamMapViewActivity.class));
        }
        if(view == btnBusan){
            startActivity(new Intent(this, BusanMapViewActivity.class));
        }
        if(view == btnKyungpook){
            startActivity(new Intent(this, KyungpookMapViewActivity.class));
        }
        if(view == btnGachon){
            startActivity(new Intent(this, GachonMapViewActivity.class));
        }
        if(view == btnJeonbuk){
            startActivity(new Intent(this, JeonbukMapViewActivity.class));
        }
        if(view == btnJeju){
            startActivity(new Intent(this, JejuMapViewActivity.class));
        }
        if(view == btnDankook2){
            startActivity(new Intent(this, DankookMapViewActivity.class));
        }
    }
}
