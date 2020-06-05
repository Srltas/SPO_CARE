package com.example.spo_care;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoViewController extends YouTubeBaseActivity {

    private final String API_KEY = "AIzaSyCO67ZZRKUzc7kwNQ3LqD7hlRl0T2IG2_M";
    private final String VIDEO_ID_1 = "GRU28UfK_4U";
    private final String VIDEO_ID_2 = "gJikKbSfXCs";
    private final String VIDEO_ID_3 = "CGMHgSLHQaY";
    private final String VIDEO_ID_4 = "NUDaqyIOtlo";
    private String message;
    YouTubePlayerView youtubeView;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.video_view);

        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);

        Intent videoViewController = getIntent();
        message = videoViewController.getStringExtra("video");

        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(selectVideo(message),YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        startYouTube();
    }
    public void startYouTube(){
        youtubeView.initialize(API_KEY,listener);
    }

    public String selectVideo(String message){
        switch(message){
            case "mouthTrainingVideo_1":
                return VIDEO_ID_1;
            case "mouthTrainingVideo_2":
                return VIDEO_ID_2;
            case "mouthTrainingVideo_3":
                return VIDEO_ID_3;
            case "mouthTrainingVideo_4":
                return VIDEO_ID_4;
        }
        return null;
    }
}