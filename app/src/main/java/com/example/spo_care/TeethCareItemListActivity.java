package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class TeethCareItemListActivity extends Activity implements View.OnClickListener {

    private LinearLayout itemVideoN1, itemVideoN2, itemVideoN3, itemVideoN4, itemVideoN5, itemVideoN6, itemVideoN7, itemVideoN8, itemVideoN9;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.teeth_care_item_list);

        itemVideoN1 = findViewById(R.id.itemVideoN1);
        itemVideoN2 = findViewById(R.id.itemVideoN2);
        itemVideoN3 = findViewById(R.id.itemVideoN3);
        itemVideoN4 = findViewById(R.id.itemVideoN4);
        itemVideoN5 = findViewById(R.id.itemVideoN5);
        itemVideoN6 = findViewById(R.id.itemVideoN6);
        itemVideoN7 = findViewById(R.id.itemVideoN7);
        itemVideoN8 = findViewById(R.id.itemVideoN8);
        itemVideoN9 = findViewById(R.id.itemVideoN9);
        itemVideoN1.setOnClickListener(this);
        itemVideoN2.setOnClickListener(this);
        itemVideoN3.setOnClickListener(this);
        itemVideoN4.setOnClickListener(this);
        itemVideoN5.setOnClickListener(this);
        itemVideoN6.setOnClickListener(this);
        itemVideoN7.setOnClickListener(this);
        itemVideoN8.setOnClickListener(this);
        itemVideoN9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.itemVideoN1:
                Intent itemVideo1 = new Intent(getApplicationContext(), TeethCareItemVideo.class);
                itemVideo1.putExtra("itemVideo","itemVideo1");
                startActivity(itemVideo1);
                break;
            case R.id.itemVideoN2:
                Intent itemVideo2 = new Intent(getApplicationContext(), TeethCareItemVideo.class);
                itemVideo2.putExtra("itemVideo","itemVideo2");
                startActivity(itemVideo2);
                break;
            case R.id.itemVideoN3:
                Intent itemVideo3 = new Intent(getApplicationContext(), TeethCareItemVideo.class);
                itemVideo3.putExtra("itemVideo","itemVideo3");
                startActivity(itemVideo3);
                break;
            case R.id.itemVideoN4:
                Intent itemVideo4 = new Intent(getApplicationContext(), TeethCareItemVideo.class);
                itemVideo4.putExtra("itemVideo","itemVideo4");
                startActivity(itemVideo4);
                break;
            case R.id.itemVideoN5:
                Intent itemVideo5 = new Intent(getApplicationContext(), TeethCareItemText.class);
                itemVideo5.putExtra("itemText","itemText5");
                startActivity(itemVideo5);
                break;
            case R.id.itemVideoN6:
                Intent itemVideo6 = new Intent(getApplicationContext(), TeethCareItemText.class);
                itemVideo6.putExtra("itemText","itemText6");
                startActivity(itemVideo6);
                break;
            case R.id.itemVideoN7:
                Intent itemVideo7 = new Intent(getApplicationContext(), TeethCareItemText.class);
                itemVideo7.putExtra("itemText","itemText7");
                startActivity(itemVideo7);
                break;
            case R.id.itemVideoN8:
                Intent itemVideo8 = new Intent(getApplicationContext(), TeethCareItemText.class);
                itemVideo8.putExtra("itemText","itemText8");
                startActivity(itemVideo8);
                break;
            case R.id.itemVideoN9:
                Intent itemVideo9 = new Intent(getApplicationContext(), TeethCareItemText.class);
                itemVideo9.putExtra("itemText","itemText9");
                startActivity(itemVideo9);
                break;
        }
    }
}
