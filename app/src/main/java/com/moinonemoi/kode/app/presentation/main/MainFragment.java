package com.moinonemoi.kode.app.presentation.main;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.moinonemoi.kode.R;
import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.presentation.page.PageFragment;
import com.moinonemoi.kode.app.presentation.page.PageFragmentPresenter;

import java.util.List;


public class MainFragment extends Fragment{

    public PageFragmentPresenter presenter = new PageFragmentPresenter();
    public PageFragment fragment;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


//        SearchView searchView = view.findViewById(R.id.searchView);
//        ImageButton sortIcon = view.findViewById(R.id.sortIcon);
//
//        sortIcon.setOnClickListener(this);
//        searchView.setOnQueryTextListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragment = new PageFragment();

        FragmentManager manager = requireActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.page_fragment_container,fragment).commit();

    }


}