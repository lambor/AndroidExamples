package com.joker.test.androidexamples.ch12;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.joker.test.androidexamples.MainActivity;
import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-8.
 *
 */

public class Ch12_7ActivityA extends AppCompatActivity implements View.OnClickListener {

    private ImageView shareImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(Build.VERSION.SDK_INT >= 21)
//            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_ch12_7_a);
        findViewById(R.id.explodeEnter).setOnClickListener(Ch12_7ActivityA.this);
        findViewById(R.id.slideEnter).setOnClickListener(Ch12_7ActivityA.this);
        findViewById(R.id.fadeEnter).setOnClickListener(Ch12_7ActivityA.this);

        shareImage = (ImageView) findViewById(R.id.shareImage);
        shareImage.setOnClickListener(Ch12_7ActivityA.this);
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= 21) {
            switch (v.getId()) {
                case R.id.explodeEnter:
                    Ch12_7ActivityB.explodeStart(Ch12_7ActivityA.this);
                    break;
                case R.id.slideEnter:
                    Ch12_7ActivityB.slideStart(Ch12_7ActivityA.this);
                    break;
                case R.id.fadeEnter:
                    Ch12_7ActivityB.fadeStart(Ch12_7ActivityA.this);
                    break;
                case R.id.shareImage:
                    Ch12_7ActivityB.shareStart(Ch12_7ActivityA.this,shareImage);
            }
        }
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch12_7ActivityA.class));
    }
}
