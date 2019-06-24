package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mylist[] myListData = new Mylist[]{
                new Mylist("Doraemon",R.drawable.doraemon),
                new Mylist("Doraemon",R.drawable.doraemon),
                new Mylist("Doraemon",R.drawable.doraemon),
                new Mylist("Doraemon",R.drawable.doraemon),
                new Mylist("Doraemon",R.drawable.doraemon)
        };

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        MyListAdapter adapter = new MyListAdapter(myListData);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }
}
