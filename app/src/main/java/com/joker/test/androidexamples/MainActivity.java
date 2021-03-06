package com.joker.test.androidexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.joker.test.androidexamples.ch03.Ch03_2Activity;
import com.joker.test.androidexamples.ch03.Ch03_6Activity;
import com.joker.test.androidexamples.ch03.Ch03_7Activity;
import com.joker.test.androidexamples.ch03.Ch03_8Activity;
import com.joker.test.androidexamples.ch04.Ch04_2Activity;
import com.joker.test.androidexamples.ch05.Ch05_2Activity;
import com.joker.test.androidexamples.ch05.Ch05_2_5FlingActivity;
import com.joker.test.androidexamples.ch05.Ch05_2_7DragHelperActivity;
import com.joker.test.androidexamples.ch06.Ch06_3Activity;
import com.joker.test.androidexamples.ch06.Ch06_4Activity;
import com.joker.test.androidexamples.ch06.Ch06_5Activity;
import com.joker.test.androidexamples.ch06.Ch06_5_2Activity;
import com.joker.test.androidexamples.ch06.Ch06_6Activity;
import com.joker.test.androidexamples.ch06.Ch06_7Activity;
import com.joker.test.androidexamples.ch06.Ch06_7_2Activity;
import com.joker.test.androidexamples.ch06.Ch06_7_3Activity;
import com.joker.test.androidexamples.ch06.Ch06_8Activity;
import com.joker.test.androidexamples.ch07.Ch07_1Activity;
import com.joker.test.androidexamples.ch07.Ch07_2Activity;
import com.joker.test.androidexamples.ch07.Ch07_5Activity;
import com.joker.test.androidexamples.ch07.Ch07_6Activity;
import com.joker.test.androidexamples.ch07.Ch07_6_5Activity;
import com.joker.test.androidexamples.ch12.Ch12MaterialStyleActivity;
import com.joker.test.androidexamples.ch12.Ch12_10Activity;
import com.joker.test.androidexamples.ch12.Ch12_3Activity;
import com.joker.test.androidexamples.ch12.Ch12_4Activity;
import com.joker.test.androidexamples.ch12.Ch12_5Activity;
import com.joker.test.androidexamples.ch12.Ch12_6Activity;
import com.joker.test.androidexamples.ch12.Ch12_7ActivityA;
import com.joker.test.androidexamples.ch12.Ch12_8Activity;
import com.joker.test.androidexamples.ch12.Ch12_9Activity;

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

        findViewById(R.id.ch05_2).setOnClickListener(this);
        findViewById(R.id.ch05_2_5).setOnClickListener(this);
        findViewById(R.id.ch05_2_7).setOnClickListener(this);

        findViewById(R.id.ch06_3).setOnClickListener(this);
        findViewById(R.id.ch06_4).setOnClickListener(this);
        findViewById(R.id.ch06_5).setOnClickListener(this);
        findViewById(R.id.ch06_5_2).setOnClickListener(this);
        findViewById(R.id.ch06_6).setOnClickListener(this);
        findViewById(R.id.ch06_7).setOnClickListener(this);
        findViewById(R.id.ch06_7_2).setOnClickListener(this);
        findViewById(R.id.ch06_7_3).setOnClickListener(this);
        findViewById(R.id.ch06_8).setOnClickListener(this);

        findViewById(R.id.ch07_1).setOnClickListener(this);
        findViewById(R.id.ch07_2).setOnClickListener(this);
        findViewById(R.id.ch07_5).setOnClickListener(this);
        findViewById(R.id.ch07_6).setOnClickListener(this);
        findViewById(R.id.ch07_6_5).setOnClickListener(this);

        findViewById(R.id.ch12_2).setOnClickListener(this);
        findViewById(R.id.ch12_3).setOnClickListener(this);
        findViewById(R.id.ch12_4).setOnClickListener(this);
        findViewById(R.id.ch12_5).setOnClickListener(this);
        findViewById(R.id.ch12_6).setOnClickListener(this);
        findViewById(R.id.ch12_7).setOnClickListener(this);
        findViewById(R.id.ch12_8).setOnClickListener(this);
        findViewById(R.id.ch12_9).setOnClickListener(this);
        findViewById(R.id.ch12_10).setOnClickListener(this);
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
            case R.id.ch05_2:
                Ch05_2Activity.start(MainActivity.this);
                break;
            case R.id.ch05_2_5:
                Ch05_2_5FlingActivity.start(MainActivity.this);
                break;
            case R.id.ch05_2_7:
                Ch05_2_7DragHelperActivity.start(MainActivity.this);
                break;
            case R.id.ch06_3:
                Ch06_3Activity.start(MainActivity.this);
                break;
            case R.id.ch06_4:
                Ch06_4Activity.start(MainActivity.this);
                break;
            case R.id.ch06_5:
                Ch06_5Activity.start(MainActivity.this);
                break;
            case R.id.ch06_5_2:
                Ch06_5_2Activity.start(MainActivity.this);
                break;
            case R.id.ch06_6:
                Ch06_6Activity.start(MainActivity.this);
                break;
            case R.id.ch06_7:
                Ch06_7Activity.start(MainActivity.this);
                break;
            case R.id.ch06_7_2:
                Ch06_7_2Activity.start(MainActivity.this);
                break;
            case R.id.ch06_7_3:
                Ch06_7_3Activity.start(MainActivity.this);
                break;
            case R.id.ch06_8:
                Ch06_8Activity.start(MainActivity.this);
                break;
            case R.id.ch07_1:
                Ch07_1Activity.start(MainActivity.this);
                break;
            case R.id.ch07_2:
                Ch07_2Activity.start(MainActivity.this);
                break;
            case R.id.ch07_5:
                Ch07_5Activity.start(MainActivity.this);
                break;
            case R.id.ch07_6:
                Ch07_6Activity.start(MainActivity.this);
                break;
            case R.id.ch07_6_5:
                Ch07_6_5Activity.start(MainActivity.this);
                break;
            case R.id.ch12_2:
                Ch12MaterialStyleActivity.start(MainActivity.this,true);
                break;
            case R.id.ch12_3:
                Ch12_3Activity.start(MainActivity.this);
                break;
            case R.id.ch12_4:
                Ch12_4Activity.start(MainActivity.this);
                break;
            case R.id.ch12_5:
                Ch12_5Activity.start(MainActivity.this);
                break;
            case R.id.ch12_6:
                Ch12_6Activity.start(MainActivity.this);
                break;
            case R.id.ch12_7:
                Ch12_7ActivityA.start(MainActivity.this);
                break;
            case R.id.ch12_8:
                Ch12_8Activity.start(MainActivity.this);
                break;
            case R.id.ch12_9:
                Ch12_9Activity.start(MainActivity.this);
                break;
            case R.id.ch12_10:
                Ch12_10Activity.start(MainActivity.this);
                break;
            default:
                break;
        }
    }
}
