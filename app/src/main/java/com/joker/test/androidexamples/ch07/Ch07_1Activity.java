package com.joker.test.androidexamples.ch07;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.joker.test.androidexamples.R;
import com.joker.test.androidexamples.ch06.Ch06_4Activity;

/**
 * Created by lambor on 17-2-28.
 */

public class Ch07_1Activity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch07_1Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch07_1);

        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.rotate).setOnClickListener(this);
        findViewById(R.id.rotate_self).setOnClickListener(this);
        findViewById(R.id.translate).setOnClickListener(this);
        findViewById(R.id.scale).setOnClickListener(this);
        findViewById(R.id.scale_self).setOnClickListener(this);
        findViewById(R.id.anim_set).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha:
                AlphaAnimation aa = new AlphaAnimation(0,1);
                aa.setDuration(1000);
                v.startAnimation(aa);
                break;
            case R.id.rotate:
                RotateAnimation ra = new RotateAnimation(0,360,100,100);
                ra.setDuration(1000);
                v.startAnimation(ra);
                break;
            case R.id.rotate_self:
                RotateAnimation raself = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                raself.setDuration(1000);
                v.startAnimation(raself);
                break;
            case R.id.translate:
                TranslateAnimation ta = new TranslateAnimation(0,200,0,300);
                ta.setDuration(1000);
                v.startAnimation(ta);
                break;
            case R.id.scale:
                ScaleAnimation sa = new ScaleAnimation(0,2,0,2);
                sa.setDuration(1000);
                v.startAnimation(sa);
                break;
            case R.id.scale_self:
                ScaleAnimation saself = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                saself.setDuration(1000);
                v.startAnimation(saself);
                break;
            case R.id.anim_set:
                AnimationSet as = new AnimationSet(true);
                as.setDuration(1000);
                AlphaAnimation _aa = new AlphaAnimation(0,1);
                _aa.setDuration(1000);
                as.addAnimation(_aa);
                TranslateAnimation _ta = new TranslateAnimation(0,100,0,200);
                _ta.setDuration(1000);
                as.addAnimation(_ta);
                v.startAnimation(as);
                break;
        }
    }
}
