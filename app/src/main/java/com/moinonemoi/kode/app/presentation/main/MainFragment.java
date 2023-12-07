package com.moinonemoi.kode.app.presentation.main;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.moinonemoi.kode.R;


public class MainFragment extends Fragment implements View.OnClickListener, SearchView.OnQueryTextListener {

    public static final String LOG_FF = "FirstFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        SearchView searchView = view.findViewById(R.id.searchView);
        ImageButton sortIcon = view.findViewById(R.id.sortIcon);

        sortIcon.setOnClickListener(this);
        searchView.setOnQueryTextListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //метод filterSearch(String newText)
        return false;
    }
}