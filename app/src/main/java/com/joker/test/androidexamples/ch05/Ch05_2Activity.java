package com.joker.test.androidexamples.ch05;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.joker.test.androidexamples.R;
import com.joker.test.androidexamples.ch04.Ch04_2OverScrollListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-2-8.
 */

public class Ch05_2Activity extends AppCompatActivity{

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch05_2Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch05_2);

    }
}
