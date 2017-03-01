package com.joker.test.androidexamples.ch07;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-1.
 */

public class Ch07_6_5Activity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView sunsysImg;
    private ImageView searchImg;

    public static void start(Context context) {
        context.startActivity(new Intent(context, Ch07_6_5Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch07_6_5);

        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Animatable) imageView.getDrawable()).start();
            }
        });

        sunsysImg = (ImageView) findViewById(R.id.sunsysImg);
        sunsysImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Animatable) sunsysImg.getDrawable()).start();
            }
        });

        searchImg = (ImageView) findViewById(R.id.searchImg);
        searchImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Animatable) searchImg.getDrawable()).start();
            }
        });

    }

}
