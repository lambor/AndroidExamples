package com.joker.test.androidexamples.ch07;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-1.
 */

public class Ch07_5Activity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context) {
        context.startActivity(new Intent(context, Ch07_5Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch07_5);

        findViewById(R.id.tvAnim).setOnClickListener(this);
        findViewById(R.id.cameraAnim).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAnim:
                Ch07_5TvShutdownAnimation tsa = new Ch07_5TvShutdownAnimation(v.getWidth()/2,v.getHeight()/2);
                tsa.setInterpolator(new AccelerateInterpolator());
                tsa.setDuration(200);
                v.startAnimation(tsa);
                break;
            case R.id.cameraAnim:
                Ch07_5CameraAnimation ca = new Ch07_5CameraAnimation();
                v.startAnimation(ca);
                break;
        }
    }
}
