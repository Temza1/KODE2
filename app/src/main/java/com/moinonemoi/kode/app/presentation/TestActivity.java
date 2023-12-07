package com.moinonemoi.kode.app.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.moinonemoi.kode.R;
import com.moinonemoi.kode.app.presentation.main.MainFragment;

public class TestActivity extends AppCompatActivity {

    MainFragment fragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        fragment = new MainFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.frameLayoutTestActivity,fragment).commit();
    }

}
