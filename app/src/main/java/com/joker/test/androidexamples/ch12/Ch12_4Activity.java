package com.joker.test.androidexamples.ch12;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-6.
 *
 */

public class Ch12_4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch12_4);

        final TextView tv = (TextView) findViewById(R.id.anim_elevation);
        tv.setOnClickListener(new View.OnClickListener() {

            boolean flag = true;
            @Override
            @TargetApi(21)
            public void onClick(View v) {
                if(flag)
                    tv.animate().translationZ(100);
                else
                    tv.animate().translationZ(0);
                flag = !flag;
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch12_4Activity.class));
    }
}
