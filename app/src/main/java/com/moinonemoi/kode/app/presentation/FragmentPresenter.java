package com.moinonemoi.kode.app.presentation;

import com.moinonemoi.kode.app.data.Item;

import java.util.List;

public interface FragmentPresenter {

    public void loadUsers();
    public void addDB(List<Item> users);
}
