package com.upgrad.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Disney[] data = {
          new Disney("Mickey","HelloFrnds",R.drawable.mickey),
          new Disney("goofy","Hey Pluto",R.drawable.goofy),
          new Disney("Donald Duck","quck quck",R.drawable.mickey),
          new Disney("Mini Mouse","Hello Mickey",R.drawable.goofy)
        };

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv1);
        DisneyAdapter adapter = new DisneyAdapter(data);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(adapter);

    }
}
