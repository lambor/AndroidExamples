package com.joker.test.androidexamples.ch12;

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
import android.view.Window;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-6.
 *
 */

public class Ch12_3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch12_3);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.lake);
        new Palette.Builder(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getDarkVibrantSwatch();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(vibrant.getRgb()));
                if(Build.VERSION.SDK_INT>=21) {
                    Window window = getWindow();
                    window.setStatusBarColor(vibrant.getRgb());
                }
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch12_3Activity.class));
    }
}
