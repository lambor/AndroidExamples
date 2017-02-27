package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-8.
 */

public class Ch06_7_2Activity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch06_7_2Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch06_7_2);
    }
}
