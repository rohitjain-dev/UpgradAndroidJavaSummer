package com.upgrad.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] avengers = {"Iron Man","Captain America","Thor","Black Widow","Hawk Eye","Dr.Strange","Spider Man","Black Panther","Winter Solider","Groot","Rocket","Peper Pots","Darx","Falcon","Ant Man"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAdapter avengersAdapter = new MyAdapter(this,avengers);
        ListView listView = (ListView) findViewById(R.id.lv1);
        listView.setAdapter(avengersAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    Toast.makeText(getApplicationContext(),"I am Iron Man",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"You are an avenger now",Toast.LENGTH_LONG).show();
            }
        });
    }
}
