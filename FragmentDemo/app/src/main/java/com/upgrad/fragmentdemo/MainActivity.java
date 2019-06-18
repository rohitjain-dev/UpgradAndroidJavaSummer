package com.upgrad.fragmentdemo;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //called the fragment class
        Fragment1 fr1 = new Fragment1();
        Fragment2 fr2 = new Fragment2();

        //called the fragment manager
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //add fragment
        fragmentTransaction.add(R.id.fragment1,fr1,"fragment1");
        fragmentTransaction.add(R.id.fragment2,fr2,"fragment2");
        //commit
        fragmentTransaction.commit();
    }
}
