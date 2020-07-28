package com.hh1995.myinsta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class YoutubeActivity extends AppCompatActivity {

    YouTubePlayerFragment youTubeFragment;
    YouTubePlayerFragment youTubeFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
//YouTubePlayerFragment가 일반 Fragment여서 Support버전을 관리하는 getSupportFramgentManger를 사용할 수 없음
        youTubeFragment= (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtubeFragment);
        youTubeFragment.initialize("first", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("7zi2CzMBa0U");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


        youTubeFragment2= (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtubeFragment2);
        youTubeFragment2.initialize("second", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("oH_QmbcfVV0");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
