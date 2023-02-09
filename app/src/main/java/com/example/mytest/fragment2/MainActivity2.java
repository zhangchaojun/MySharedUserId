package com.example.mytest.fragment2;



import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.myfragmentlifecycle.R;

/**
 * sdk中的原生fragment
 */
public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment2 fragment2 = new Fragment2();
        fragmentTransaction.add(fragment2,"fragment2").show(fragment2).commit();
    }
}