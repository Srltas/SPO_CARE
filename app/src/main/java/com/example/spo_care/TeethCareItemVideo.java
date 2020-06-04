package com.example.spo_care;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class TeethCareItemVideo extends YouTubeBaseActivity {

    private String message;
    private final String API_KEY = "AIzaSyCO67ZZRKUzc7kwNQ3LqD7hlRl0T2IG2_M";
    private final String ITEM_VIDEO_1 = "uR8Mrt1IpXg";
    private final String ITEM_VIDEO_2 = "6uJf2IT2Zh8";
    private final String ITEM_VIDEO_3 = "WyiIGEHQP8o";

    private TextView title, text;
    private ImageView image;
    private YouTubePlayerView youtubeView;
    private YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.teeth_care_item_video);

        youtubeView = (YouTubePlayerView) findViewById(R.id.itemYoutubeView);
        title = findViewById(R.id.itemVideoTitle);
        text = findViewById(R.id.itemVideoText);
        image = findViewById(R.id.itemVideoImage);

        Intent videoViewController = getIntent();
        message = videoViewController.getStringExtra("itemVideo");

        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(selectVideo(message));
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        startYouTube();
    }
    public void startYouTube(){youtubeView.initialize(API_KEY,listener);}

    public String selectVideo(String message){
        int id;
        switch(message){
            case "itemVideo1":
                title.setText(R.string.itemNumber1);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_1",null,null);
                image.setImageResource(id);
                text.setText(R.string.item1);
                return ITEM_VIDEO_1;
            case "itemVideo2":
                title.setText(R.string.itemNumber2);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_2",null,null);
                image.setImageResource(id);
                text.setText(R.string.itme2);
                return ITEM_VIDEO_1;
            case "itemVideo3":
                title.setText(R.string.itemNumber3);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_3",null,null);
                image.setImageResource(id);
                text.setText(R.string.itme3);
                return ITEM_VIDEO_2;
            case "itemVideo4":
                title.setText(R.string.itemNumber4);
                id = getResources().getIdentifier("com.example.spo_care:drawable/image_item_4",null,null);
                image.setImageResource(id);
                text.setText(R.string.itme4);
                return ITEM_VIDEO_3;
        }
        return null;
    }
}
