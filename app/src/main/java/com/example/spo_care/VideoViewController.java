package com.example.spo_care;

import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoViewController extends YouTubeBaseActivity implements View.OnClickListener{

    YouTubePlayerView youtubeView;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.video_view);

        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("uR8Mrt1IpXg");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
    }
    @Override
    public void onClick(View view){
        if(view == youtubeView){
            youtubeView.initialize("AIzaSyCO67ZZRKUzc7kwNQ3LqD7hlRl0T2IG2_M",listener);
        }
    }
}