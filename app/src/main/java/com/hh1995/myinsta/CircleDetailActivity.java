package com.hh1995.myinsta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class CircleDetailActivity extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_detail);
        iv=findViewById(R.id.iv);

        Intent intent=getIntent();
        int img=intent.getIntExtra("img",R.drawable.bg_one01);
        String id=intent.getStringExtra("id");

        Glide.with(this).load(img).into(iv);

        getSupportActionBar().setTitle(id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            iv.setTransitionName("IMG");
        }
    }
}
