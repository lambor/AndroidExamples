package com.joker.test.androidexamples.ch12;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.joker.test.androidexamples.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-3-6.
 */

public class Ch12_8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch12_8);

        final View oval = findViewById(R.id.oval);
        oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 21) {
                    Animator animator = ViewAnimationUtils.createCircularReveal(oval, oval.getWidth() / 2, oval.getHeight() / 2, oval.getWidth(), 0);
                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
                    animator.setDuration(500);
                    animator.start();
                }
            }
        });

        final View rect = findViewById(R.id.rect);
        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 21) {
                    Animator animator = ViewAnimationUtils.createCircularReveal(rect, 0, 0, 0, (float) Math.hypot(rect.getWidth(), rect.getHeight()));
                    animator.setInterpolator(new AccelerateInterpolator());
                    animator.setDuration(500);
                    animator.start();
                }
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, Ch12_8Activity.class));
    }

}
