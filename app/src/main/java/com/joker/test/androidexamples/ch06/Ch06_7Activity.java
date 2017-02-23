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

public class Ch06_7Activity extends AppCompatActivity {


    Ch06_7XfermodeView v1;
    Ch06_7XfermodeView v2;
    Ch06_7XfermodeView v3;

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch06_7Activity.class));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch06_7);

        v1 = (Ch06_7XfermodeView) findViewById(R.id.view1);
        v1.setSrcPaintXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        v2 = (Ch06_7XfermodeView) findViewById(R.id.view2);
        v2.setSrcPaintXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        v3 = (Ch06_7XfermodeView) findViewById(R.id.view3);
        v3.setSrcPaintXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
}
