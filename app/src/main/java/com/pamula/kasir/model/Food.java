package com.pamula.kasir.model;

import android.support.annotation.Nullable;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by DEKSTOP on 12/01/2017.
 */
public class Food extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    @Index
    private String category;
    private String price;
    @Nullable
    private String date;

    public Food() {}

    public Food(int id, String name, String category, String price, String date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
