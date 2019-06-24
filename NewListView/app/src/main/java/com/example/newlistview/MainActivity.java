package com.example.newlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;

    String[] str = {"Doraemon","Inuzama Eleven","Naruto","Popeye","shinchan"};

    Integer[] in = {R.drawable.doraemon,R.drawable.inazuma,R.drawable.naruto,R.drawable.popeye,R.drawable.shinchan};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyListAdapter second = new MyListAdapter(this,str,in);
        list = (ListView)findViewById(R.id.lv);
        list.setAdapter(second);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    Toast.makeText(getApplicationContext(),"Doraemon is my favourite",Toast.LENGTH_LONG).show();
                else if(position==1)
                    Toast.makeText(getApplicationContext(), "Inazuma Eleven is ultimate", Toast.LENGTH_SHORT).show();
                else if(position==2)
                    Toast.makeText(getApplicationContext(),"Naruto",Toast.LENGTH_SHORT).show();
                else if (position==3)
                    Toast.makeText(getApplicationContext(),"Popeye is legend",Toast.LENGTH_SHORT).show();
                else if (position==4)
                    Toast.makeText(getApplicationContext(),"shinchan and sheero",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
