package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TeethCareItemText extends Activity {

    private String message;
    private TextView title, text;
    private ImageView image;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.teeth_care_item_text);

        title = findViewById(R.id.itemTextTitle);
        text = findViewById(R.id.itemTextText);
        image = findViewById(R.id.itemTextImage);

        Intent videoViewController = getIntent();
        message = videoViewController.getStringExtra("itemText");
        selectText();
    }

    public void selectText(){
        int id;
        switch(message){
            case "itemText5":
                title.setText(R.string.itemNumber5);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_5",null,null);
                image.setImageResource(id);
                text.setText(R.string.item5);
                break;
            case "itemText6":
                title.setText(R.string.itemNumber6);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_6",null,null);
                image.setImageResource(id);
                text.setText(R.string.item6);
                break;
            case "itemText7":
                title.setText(R.string.itemNumber7);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_7",null,null);
                image.setImageResource(id);
                text.setText(R.string.item7);
                break;
            case "itemText8":
                title.setText(R.string.itemNumber8);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_8",null,null);
                image.setImageResource(id);
                text.setText(R.string.item8);
                break;
            case "itemText9":
                title.setText(R.string.itemNumber9);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_9",null,null);
                image.setImageResource(id);
                text.setText(R.string.item9);
                break;
        }
    }
}
