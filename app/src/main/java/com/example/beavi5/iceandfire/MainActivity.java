package com.example.beavi5.iceandfire;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
RecyclerView rvHeroes;
    Parser parser;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes= (RecyclerView) findViewById(R.id.rvHeroes);

        LinearLayoutManager mllm = new LinearLayoutManager(this);
       // mllm.setStackFromEnd(true);
        mllm.setReverseLayout(true);
        rvHeroes.setLayoutManager(mllm);

        parser = new Parser(rvHeroes);
        parser.parse();


        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               parser.parse();
                swipeContainer.setRefreshing(false);

            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_green_light,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);




    }

}
