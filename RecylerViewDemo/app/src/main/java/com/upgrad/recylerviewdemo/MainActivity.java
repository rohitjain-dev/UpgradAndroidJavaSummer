package com.upgrad.recylerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TMKC [] characterList = new TMKC[]{
          new TMKC("Jethalal","Good Morning BabitaJI",R.drawable.jethalal),
          new TMKC("Popatlal","Duniya Hilla Dunga",R.drawable.popatlal),
          new TMKC("Dayaben","Hey Maa Mataji",R.drawable.dayaben),
          new TMKC("Bhide","Ekmave Secteray",R.drawable.bhide),
          new TMKC("Sodhi","O jetha Praa",R.drawable.sodhi)
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.tmkccharlist);
        TMKCAdapter adapter = new TMKCAdapter(characterList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
