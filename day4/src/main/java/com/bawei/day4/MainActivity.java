package com.bawei.day4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bawei.day4.adapter.MyAdapter;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
   private MyAdapter myAdapter;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        gridLayoutManager = new GridLayoutManager(this, 3);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {


                myAdapter.selectedAll();
            }
        });

        myAdapter.setOnItemLongClickListener(new MyAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View v, int position) {


                myAdapter.revertSelected();
            }
        });
        recyclerView.addItemDecoration(new MyDecoration(this, LinearLayoutManager.VERTICAL));
    }



    public void onClick(View v) {


        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }

        if (layoutManager instanceof GridLayoutManager) {
            recyclerView.setLayoutManager(linearLayoutManager);


            recyclerView.setAdapter(myAdapter);
        } else if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(myAdapter);
        }
    }
}
