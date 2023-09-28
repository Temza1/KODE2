package com.moinonemoi.kode.app.presentation.presentation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moinonemoi.kode.app.App;
import com.moinonemoi.kode.app.data.Item;
import com.moinonemoi.kode.app.data.UsersDataBase;
import com.moinonemoi.kode.app.presentation.ItemAdapter;
import com.moinonemoi.kode.R;

import java.util.List;

import javax.inject.Inject;


public class FirstFragment extends Fragment implements FragmentView{


    private RecyclerView recyclerViewUsers;
    private ItemAdapter itemAdapter;
    private UsersDataBase usersDataBase;
    @Inject FirstFragmentPresenter presenter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);


        recyclerViewUsers = view.findViewById(R.id.recyclerViewUsers);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        itemAdapter = new ItemAdapter();
        recyclerViewUsers.setAdapter(itemAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Application application = requireActivity().getApplication();
        usersDataBase = UsersDataBase.getInstance(application);

        App.
        presenter.loadUsers();

        /*viewModel.loadUsers(itemAdapter);*/


    }


    @Override
    public void showResult(List<Item> users) {
        itemAdapter.setUsers(users);
    }
}