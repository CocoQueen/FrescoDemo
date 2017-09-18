package com.example.recyclerviewmore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<>();
    RecyclerView mRe;
    LinearLayoutManager manager;
    MyAdapter adapter;
    int maxValue = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        initView();
    }

    private void initDate() {
        for (int i = 0; i < 100; i++) {
            list.add("aaaa" + i);
        }
    }

    private void initView() {
        manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        mRe = (RecyclerView) findViewById(R.id.mRe);
        adapter = new MyAdapter(this, list);
        mRe.setAdapter(adapter);
        mRe.setLayoutManager(manager);
        mRe.addItemDecoration(new MyItemDecoration(this,LinearLayoutManager.VERTICAL));
    }
}
