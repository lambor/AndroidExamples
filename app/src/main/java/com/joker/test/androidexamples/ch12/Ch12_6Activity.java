package com.joker.test.androidexamples.ch12;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.joker.test.androidexamples.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-3-6.
 */

public class Ch12_6Activity extends AppCompatActivity {

    private RecyclerView rcList;
    private Button addBtn;
    private Button delBtn;

    private List<String> mData = new ArrayList<>();
    private Ch12_6RecyclerAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch12_6);

        rcList = (RecyclerView) findViewById(R.id.rc_list);
        adapter = new Ch12_6RecyclerAdapter(mData);
        rcList.setAdapter(adapter);
        rcList.setLayoutManager(new LinearLayoutManager(Ch12_6Activity.this));
        rcList.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(new Ch12_6RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {
                if (Build.VERSION.SDK_INT >= 21) {
                    view.animate().translationZ(15f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                        @Override
                        @TargetApi(21)
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.animate().translationZ(1f).setDuration(500).start();
                        }
                    }).start();
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRecycler();
            }
        });
        delBtn = (Button) findViewById(R.id.delBtn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delRecycler();
            }
        });

        String[] types = getResources().getStringArray(R.array.spinner_rclist_type);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, types));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) { //linear
                    rcList.setLayoutManager(new LinearLayoutManager(Ch12_6Activity.this));
                } else if (position == 1) { //grid
                    rcList.setLayoutManager(new GridLayoutManager(Ch12_6Activity.this, 3));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, Ch12_6Activity.class));
    }

    public void addRecycler() {
        mData.add("Recycler");
        int position = mData.size();
        if (position > 0) {
            adapter.notifyDataSetChanged();
        }
    }

    public void delRecycler() {
        int position = mData.size();
        if (position > 0) {
            mData.remove(position - 1);
            adapter.notifyDataSetChanged();
        }
    }


}
