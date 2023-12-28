package com.moinonemoi.kode.app.presentation.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.moinonemoi.kode.R;
import com.moinonemoi.kode.app.presentation.page.PageFragment;


public class FragmentAdapter extends FragmentStateAdapter {

    private String searchText;
    private Boolean booleanSort;

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public void setBooleanSort(Boolean booleanSort) {
        this.booleanSort = booleanSort;
    }

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        PageFragment fragment = new PageFragment();

        if(searchText != null && !booleanSort) {
            fragment.addArgs(position,searchText, false,fragment);
        } else if (searchText != null) {
            fragment.addArgs(position, searchText,fragment);
        } else if (!booleanSort){
            fragment.addArgs(position,false,fragment);
        } else {
            fragment.addArgs(position,fragment);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 13;
    }

}
