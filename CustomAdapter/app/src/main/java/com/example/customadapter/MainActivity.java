package com.example.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.customadapter.MyListAdapter;
import com.example.customadapter.R;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] str = {"This is fruit","This is company","I am Goku","Hi this is kylie","hi i am kim"};

    Integer[] in = {R.drawable.apple,R.drawable.apple_mobile,R.drawable.goku,R.drawable.kylie,R.drawable.kim};

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
                if(position == 0)
                    Toast.makeText(getApplicationContext(),"I love eating apple but i cant afford it",Toast.LENGTH_SHORT).show();

                else if(position== 1)
                    Toast.makeText(getApplicationContext(),"I like apple iphones but i cant afford it",Toast.LENGTH_SHORT).show();

                else if(position==2)
                    Toast.makeText(getApplicationContext(),"goku",Toast.LENGTH_SHORT).show();
                else if(position==3)
                    Toast.makeText(getApplicationContext(),"kylie",Toast.LENGTH_SHORT).show();
                else if(position==4)
                    Toast.makeText(getApplicationContext(),"kim",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
