package com.joker.test.androidexamples.ch12;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-6.
 */

public class Ch12MaterialStyleActivity extends AppCompatActivity {

    private static final String EXTRA_DARKSTYLE = "darkstyle";

    public static void start(Context context,boolean dark) {
        Intent intent = new Intent(context,Ch12MaterialStyleActivity.class);
        intent.putExtra(EXTRA_DARKSTYLE,dark);
        context.startActivity(intent);
    }

    private boolean darkStyle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        darkStyle = getIntent().getBooleanExtra(EXTRA_DARKSTYLE,false);
        setTheme(darkStyle?R.style.DarkMaterial:R.style.LightMaterial);
        setContentView(R.layout.activity_ch12_2);

        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(Ch12MaterialStyleActivity.this,!darkStyle);
                finish();
            }
        });
    }
}
