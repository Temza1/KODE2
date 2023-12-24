package com.moinonemoi.kode.app.presentation.page;

import android.app.Application;
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
import com.moinonemoi.kode.app.base.App;
import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.presentation.main.FragmentView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class PageFragment extends Fragment implements FragmentView, View.OnClickListener {


    public static final String LOG_PAGE_FRAGMENT = "PageFragment";
    private ItemAdapter itemAdapter;



    PageFragmentPresenter presenter = new PageFragmentPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        presenter.getWorkerList();
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





}