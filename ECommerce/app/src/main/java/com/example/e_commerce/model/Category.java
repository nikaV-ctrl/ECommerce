package com.example.e_commerce.model;

public class Category {

    int id;
    String title;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // получает значение из поля
    public int getId() {
        return id;
    }

    // устанавливает значение в поле
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
