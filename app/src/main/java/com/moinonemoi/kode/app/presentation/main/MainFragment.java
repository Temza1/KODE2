package com.moinonemoi.kode.app.presentation.main;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.moinonemoi.kode.R;
import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.presentation.main.entity.MainFragmentView;
import com.moinonemoi.kode.app.presentation.page.PageFragment;
import com.moinonemoi.kode.app.presentation.page.PageFragmentPresenter;

import java.util.List;


public class MainFragment extends Fragment implements MainFragmentView {

    public PageFragmentPresenter presenter = new PageFragmentPresenter();
    public PageFragment fragment;

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        viewPager2 = view.findViewById(R.id.viewPager2);
        tabLayout = view.findViewById(R.id.tabLayout);

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

//        fragment = new PageFragment();
//
//        FragmentManager manager = requireActivity().getSupportFragmentManager();
//        FragmentTransaction ft = manager.beginTransaction();
//        ft.add(R.id.page_fragment_container,fragment).commit();

        FragmentAdapter adapter = new FragmentAdapter(requireActivity().getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);


        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0 :
                        //TODO: сделать название табов
                        break;
                    case 1 :

                        break;
                    case 2 :

                        break;
                }
            }
        }).attach();



    }


    @Override
    public void getCategoryList(List<String> list) {

    }

    public void launchFragment(Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        manager.beginTransaction()
                .replace(R.id.page_fragment_container,fragment)
                .addToBackStack(null)
                .commit();
    }
}