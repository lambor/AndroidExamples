package com.joker.test.androidexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joker.test.androidexamples.ch03.Ch03_2Activity;
import com.joker.test.androidexamples.ch03.Ch03_6Activity;
import com.joker.test.androidexamples.ch03.Ch03_7Activity;
import com.joker.test.androidexamples.ch03.Ch03_8Activity;
import com.joker.test.androidexamples.ch04.Ch04_2Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ch03_2).setOnClickListener(this);
        findViewById(R.id.ch03_6).setOnClickListener(this);
        findViewById(R.id.ch03_7).setOnClickListener(this);
        findViewById(R.id.ch03_8).setOnClickListener(this);

        findViewById(R.id.ch04_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ch03_2:
                Ch03_2Activity.start(MainActivity.this);
                break;
            case R.id.ch03_6:
                Ch03_6Activity.start(MainActivity.this);
                break;
            case R.id.ch03_7:
                Ch03_7Activity.start(MainActivity.this);
                break;
            case R.id.ch03_8:
                Ch03_8Activity.start(MainActivity.this);
                break;
            case R.id.ch04_2:
                Ch04_2Activity.start(MainActivity.this);
                break;
            default:
                break;
        }
    }
}
