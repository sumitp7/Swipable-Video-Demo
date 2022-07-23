package com.sumit.swipablevideosdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<VideoModel> videoList;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoList = new ArrayList<>();
        viewPager2 = findViewById(R.id.viewpager);

        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.a
                ,"Video 1","No Desc"));
        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.b
                ,"Video 2","No Desc"));
        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.c
                ,"Video 3","No Desc"));
        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.d
                ,"Video 4","No Desc"));
        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.a
                ,"Video 5","No Desc"));
        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.b
                ,"Video 6","No Desc"));
        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.c
                ,"Video 7","No Desc"));
        videoList.add(new VideoModel("android.resource://" +getPackageName() + "/" + R.raw.d
                ,"Video 8","No Desc"));


        videoAdapter = new VideoAdapter(videoList);
        viewPager2.setAdapter(videoAdapter);

    }

}