package com.moinonemoi.kode.app.presentation.page;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moinonemoi.kode.R;
import com.moinonemoi.kode.app.data.entity.Item;

import java.util.List;


public class PageFragment extends Fragment implements FragmentView, View.OnClickListener {


    public static final String LOG_PAGE_FRAGMENT = "PageFragment";
    public static final String CATEGORY_NUMBER = "categoryNumber";
    public static final String SEARCH_TEXT = "searchText";
    public static final String BOOLEAN_SORT = "booleanSort";

    private ItemAdapter itemAdapter;

    private int positionFragmentAdapter;
    private String searchText;
    private Boolean booleanSort;



    PageFragmentPresenter presenter = new PageFragmentPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            positionFragmentAdapter = getArguments().getInt(CATEGORY_NUMBER);
            searchText = getArguments().getString(SEARCH_TEXT);
            booleanSort = getArguments().getBoolean(BOOLEAN_SORT);
        }
        /*App.appComponent.inject(this);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        RecyclerView recyclerViewUsers = view.findViewById(R.id.recyclerViewUsers);
        setItemAdapter(recyclerViewUsers);
        return view;
    }

    public void setItemAdapter(RecyclerView view) {
        itemAdapter = new ItemAdapter();
        view.setAdapter(itemAdapter);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        presenter.attachView(this);

        if(searchText != null && !booleanSort) {

        } else if (searchText != null) {

        } else if (!booleanSort){

        } else {
            presenter.getWorkerList();
        }

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showResult(List<Item> users) {

        itemAdapter.setUsers(users);
        Log.d(LOG_PAGE_FRAGMENT,"список отправлен в адаптер");


    }

    @Override
    public void onClick(View view) {
    }

    public void addArgs(int position,Fragment fragment) {
        Bundle args = new Bundle();
        args.putInt(CATEGORY_NUMBER,position);
        fragment.setArguments(args);
    }

    public void addArgs(int position,String searchText,Fragment fragment) {
        Bundle args = new Bundle();
        args.putInt(CATEGORY_NUMBER,position);
        args.putString(SEARCH_TEXT,searchText);
        fragment.setArguments(args);
    }

    public void addArgs(int position,String searchText,Boolean booleanSort,Fragment fragment) {
        Bundle args = new Bundle();
        args.putInt(CATEGORY_NUMBER,position);
        args.putString(SEARCH_TEXT,searchText);
        args.putBoolean(BOOLEAN_SORT,booleanSort);
        fragment.setArguments(args);

    }

    public void addArgs(int position,Boolean booleanSort,Fragment fragment) {
        Bundle args = new Bundle();
        args.putInt(CATEGORY_NUMBER,position);
        args.putBoolean(BOOLEAN_SORT,booleanSort);
        fragment.setArguments(args);
    }









}