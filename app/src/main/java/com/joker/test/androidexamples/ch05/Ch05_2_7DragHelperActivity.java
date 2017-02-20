package com.joker.test.androidexamples.ch05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-8.
 */

public class Ch05_2_7DragHelperActivity extends AppCompatActivity{

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch05_2_7DragHelperActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch05_2_7);

    }
}
