package com.joker.test.androidexamples.ch12;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.View;
import android.view.Window;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-8.
 *
 */

public class Ch12_7ActivityB extends AppCompatActivity implements View.OnClickListener {

    private static final String EXTRA_TYPE = "type";
    private static final int TYPE_EXPLODE = 0;
    private static final int TYPE_SLIDE = 1;
    private static final int TYPE_FADE = 2;
    private static final int TYPE_SHARE = 3;

    @TargetApi(21)
    public static void explodeStart(Context context) {
        Intent intent = new Intent(context,Ch12_7ActivityB.class);
        intent.putExtra(EXTRA_TYPE,TYPE_EXPLODE);
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(((Activity) context)).toBundle());
    }

    @TargetApi(21)
    public static void slideStart(Context context) {
        Intent intent = new Intent(context,Ch12_7ActivityB.class);
        intent.putExtra(EXTRA_TYPE,TYPE_SLIDE);
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(((Activity) context)).toBundle());
    }

    @TargetApi(21)
    public static void fadeStart(Context context) {
        Intent intent = new Intent(context,Ch12_7ActivityB.class);
        intent.putExtra(EXTRA_TYPE,TYPE_FADE);
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(((Activity) context)).toBundle());
    }

    @TargetApi(21)
    public static void shareStart(Context context,View share) {
        Intent intent = new Intent(context,Ch12_7ActivityB.class);
        intent.putExtra(EXTRA_TYPE,TYPE_SHARE);
        context.startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(((Activity) context), Pair.create(share,"share")).toBundle());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            int type = getIntent().getIntExtra(EXTRA_TYPE, -1);
            if (type == TYPE_EXPLODE) {
                getWindow().setEnterTransition(new Explode());
            } else if(type == TYPE_FADE) {
                getWindow().setEnterTransition(new Fade());
            } else if(type == TYPE_SLIDE) {
                getWindow().setEnterTransition(new Slide());
            }
        }

        setContentView(R.layout.activity_ch12_7_b);
        findViewById(R.id.explodeExit).setOnClickListener(Ch12_7ActivityB.this);
        findViewById(R.id.slideExit).setOnClickListener(Ch12_7ActivityB.this);
        findViewById(R.id.fadeExit).setOnClickListener(Ch12_7ActivityB.this);
        findViewById(R.id.shareImage).setOnClickListener(Ch12_7ActivityB.this);
    }

    @Override
    public void onClick(View v) {
        if(Build.VERSION.SDK_INT >= 21) {
            switch (v.getId()) {
                case R.id.explodeExit:
                    getWindow().setExitTransition(new Explode());
                    break;
                case R.id.slideExit:
                    getWindow().setExitTransition(new Slide());
                    break;
                case R.id.fadeExit:
                    getWindow().setExitTransition(new Fade());
                    break;
            }
            finishAfterTransition();
        }
    }
}
