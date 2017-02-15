package com.joker.test.androidexamples.ch04;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-2-8.
 */

public class Ch04_2Activity extends AppCompatActivity{

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch04_2Activity.class));
    }

    private Ch04_2OverScrollListView listView;

    private Toolbar toolbar;
    private boolean mShow = true;


    private Animator mAnimator;
    private void toolbarAnim(int flag) {
        if(mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if(flag == 0 ){
            mAnimator = ObjectAnimator.ofFloat(toolbar,"translationY",toolbar.getTranslationY(),0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(toolbar,"translationY",toolbar.getTranslationY(),-toolbar.getHeight());
        }
        mAnimator.start();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch04_2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        listView = (Ch04_2OverScrollListView) findViewById(R.id.list);
        List<String> data = new ArrayList<>();
        for(int i=0;i<10;i++) data.add("test");
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data));

        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.action_bar_height)));
        listView.addHeaderView(header);

        final float mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();

        listView.setOnTouchListener(new View.OnTouchListener() {

            float mFirstY;
            float mCurrentY;
            int direction;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mFirstY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mCurrentY = event.getY();
                        if(mCurrentY - mFirstY > mTouchSlop) {
                            direction = 0; //down
                        } else if(mFirstY - mCurrentY > mTouchSlop) {
                            direction = 1; //up
                        }

                        if(direction == 1) {
                            if(mShow) {
                                toolbarAnim(0); //hide
                                mShow = !mShow;
                            }
                        } else if(direction == 0) {
                            if(!mShow) {
                                toolbarAnim(1);
                                mShow = !mShow;
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;

                }
                return false;
            }
        });

    }
}
