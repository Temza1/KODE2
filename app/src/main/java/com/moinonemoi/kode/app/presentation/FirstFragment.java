package com.moinonemoi.kode.app.presentation;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moinonemoi.kode.app.App;
import com.moinonemoi.kode.app.data.Item;
import com.moinonemoi.kode.R;

import java.util.List;

import javax.inject.Inject;


public class FirstFragment extends Fragment implements FragmentView{

    public static final String LOG_FF = "FirstFragment";

    private ItemAdapter itemAdapter;
    @Inject FirstFragmentPresenter presenter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        RecyclerView recyclerViewUsers = view.findViewById(R.id.recyclerViewUsers);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        if(container == null) {
            Log.d(LOG_FF,"КОНТЕЙНЕР ПУСТ");
        }

        itemAdapter = new ItemAdapter();
        recyclerViewUsers.setAdapter(itemAdapter);
        if(itemAdapter == null) {
            Log.d(LOG_FF,"АДАПТЕР ПУСТ");
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Application application = requireActivity().getApplication();
        /*UsersDataBase usersDataBase = UsersDataBase.getInstance(application);*/
        App.appComponent.inject(this);
        if(presenter != null) {
            presenter.loadUsers();
        } else {
            Log.d(LOG_FF,"ОШИБКА НAЛ");
        }

        /*viewModel.loadUsers(itemAdapter);*/


    }




    @Override
    public void showResult(List<Item> users) {
            itemAdapter.setUsers(users);
    }
}