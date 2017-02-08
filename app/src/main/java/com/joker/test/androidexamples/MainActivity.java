package com.joker.test.androidexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joker.test.androidexamples.ch03.Ch03_2Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ch03_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ch03_2:
                Ch03_2Activity.start(MainActivity.this);
                break;
            default:
                break;
        }
    }
}
