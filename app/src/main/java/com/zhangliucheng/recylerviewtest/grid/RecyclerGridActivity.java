package com.zhangliucheng.recylerviewtest.grid;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.zhangliucheng.recylerviewtest.City;
import com.zhangliucheng.recylerviewtest.R;
import com.zhangliucheng.recylerviewtest.linear.RecyclerLinearAdapter;
import com.zhangliucheng.recylerviewtest.linear.RecyclerLinearDivider;

public class RecyclerGridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_grid);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("GridManager");

        recyclerView = (RecyclerView) findViewById(R.id.recylerView);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        // 设置布局管理器
        recyclerView.setLayoutManager(manager);

        // 设置动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置适配器
        adapter = new RecyclerGridAdapter(this, recyclerView, City.getTestData());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycle_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.add:
                adapter.addCity();
                break;

            case R.id.delete:
                adapter.deleteCity();
                break;
            default:
                break;
        }
        return true;
    }
}
