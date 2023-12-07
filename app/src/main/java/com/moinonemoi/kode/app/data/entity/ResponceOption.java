package com.moinonemoi.kode.app.data.entity;

public enum ResponceOption {

    SUCCESS("успех"),
    DYNAMIC("динамический"),
    ERROR("ошибка");

    private String title;

    ResponceOption(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
