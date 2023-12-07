package com.moinonemoi.kode.app.presentation;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moinonemoi.kode.R;
import com.moinonemoi.kode.app.App;
import com.moinonemoi.kode.app.data.Item;

import java.util.List;

import javax.inject.Inject;


public class SecondaryFragment extends Fragment implements FragmentView {

    private ItemAdapter itemAdapter;

    @Inject
    FirstFragmentPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secondary, container, false);

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

        Application application = requireActivity().getApplication();

        presenter.attachView(this);
        presenter.initDB(application);
        presenter.loadUsers();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showResult(List<Item> users) {
        itemAdapter.setUsers(users);
    }
}