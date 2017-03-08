package com.joker.test.androidexamples.ch12;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-6.
 *
 */

public class Ch12_5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch12_5);

        if(Build.VERSION.SDK_INT >= 21)
            clip();
    }

    @TargetApi(21)
    private void clip() {
        View v1 = findViewById(R.id.roundCornerBtn);
        View v2 = findViewById(R.id.circleBtn);
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0,0,view.getWidth(),view.getHeight(),30);
            }
        };
        ViewOutlineProvider viewOutlineProvider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0,0,view.getWidth(),view.getHeight());
            }
        };
        v1.setOutlineProvider(viewOutlineProvider1);
        v2.setOutlineProvider(viewOutlineProvider2);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch12_5Activity.class));
    }
}
