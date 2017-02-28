package com.joker.test.androidexamples.ch07;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-28.
 */

public class Ch07_2Activity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context) {
        context.startActivity(new Intent(context, Ch07_2Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch07_2);

        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.rotatex).setOnClickListener(this);
        findViewById(R.id.rotatey).setOnClickListener(this);
        findViewById(R.id.rotatez).setOnClickListener(this);
        findViewById(R.id.translate).setOnClickListener(this);
        findViewById(R.id.scale).setOnClickListener(this);
        findViewById(R.id.objanimatorset).setOnClickListener(this);
        findViewById(R.id.animatorset).setOnClickListener(this);
        findViewById(R.id.view_anim).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha:
                ObjectAnimator aa = ObjectAnimator.ofFloat(v,"alpha",0f,1f);
                aa.setDuration(1000);
                aa.start();
                break;
            case R.id.rotatex:
                ObjectAnimator rax = ObjectAnimator.ofFloat(v,"rotationX",0,360);
                rax.setDuration(1000);
                rax.start();
                break;
            case R.id.rotatey:
                ObjectAnimator ray = ObjectAnimator.ofFloat(v,"rotationY",0,360);
                ray.setDuration(1000);
                ray.start();
                break;
            case R.id.rotatez:
                ObjectAnimator raz = ObjectAnimator.ofFloat(v,"rotation",0,360);
                raz.setDuration(1000);
                raz.start();
                break;
            case R.id.translate:
                PropertyValuesHolder xHolder = PropertyValuesHolder.ofFloat("X",0,200);
                PropertyValuesHolder yHolder = PropertyValuesHolder.ofFloat("Y",0,300);
                ObjectAnimator.ofPropertyValuesHolder(v,xHolder,yHolder).setDuration(1000).start();
                break;
            case R.id.scale:
                PropertyValuesHolder scaleXHolder = PropertyValuesHolder.ofFloat("scaleX",1,2);
                PropertyValuesHolder scaleYHolder = PropertyValuesHolder.ofFloat("scaleY",1,2);
                ObjectAnimator.ofPropertyValuesHolder(v,scaleXHolder,scaleYHolder).setDuration(1000).start();
                break;
            case R.id.objanimatorset:
                PropertyValuesHolder _alphaHolder = PropertyValuesHolder.ofFloat("alpha",0f,1f);
                PropertyValuesHolder _scaleXHolder = PropertyValuesHolder.ofFloat("scaleX",1,2);
                ObjectAnimator.ofPropertyValuesHolder(v,_alphaHolder,_scaleXHolder).setDuration(1000).start();
                break;
            case R.id.animatorset:
                ObjectAnimator _aa = ObjectAnimator.ofFloat(v,"alpha",0f,1f);
                ObjectAnimator _ta = ObjectAnimator.ofFloat(v,"X",0,200);
                AnimatorSet as = new AnimatorSet();
                as.playTogether(_aa,_ta);
                as.start();
                break;
            case R.id.view_anim:
                v.animate().alpha(0).x(300).start();
                break;
        }
    }
}
