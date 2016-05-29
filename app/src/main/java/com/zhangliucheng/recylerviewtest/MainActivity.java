package com.zhangliucheng.recylerviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhangliucheng.recylerviewtest.grid.RecyclerGridActivity;
import com.zhangliucheng.recylerviewtest.linear.RecyclerLinearActivity;
import com.zhangliucheng.recylerviewtest.staggered.RecyclerStaggeredGridActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("RecyclerView");
    }

    public void linearManagerClick(View v) {
        Intent intent = new Intent(this, RecyclerLinearActivity.class);
        startActivity(intent);
    }

    public void gridLayoutManager(View v) {
        Intent intent = new Intent(this, RecyclerGridActivity.class);
        startActivity(intent);
    }

    public void staggeredGridLayoutManager(View v) {
        Intent intent = new Intent(this, RecyclerStaggeredGridActivity.class);
        startActivity(intent);
    }
}
