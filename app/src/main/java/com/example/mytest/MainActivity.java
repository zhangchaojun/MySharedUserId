package com.example.mytest;

import android.view.View;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cj.library.base.BaseActivity;
import com.example.myfragmentlifecycle.R;

/**
 * androidx中的fragment
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "cj";
    private Fragment1 fragment1;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragment1 = new Fragment1(R.layout.fragment_1);
        fragmentTransaction.add(fragment1,"fragment1").show(fragment1).commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:

                break;
        }
    }


}
