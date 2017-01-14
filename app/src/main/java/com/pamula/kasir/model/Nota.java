package com.pamula.kasir.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by DEKSTOP on 13/01/2017.
 */
public class Nota extends RealmObject {

    private int id;
    private int idn;
    private String menu;
    private String harga;
    private int qty;

    public Nota() {
    }

    public Nota(int id, int idn, String menu, String harga, int qty) {
        this.id = id;
        this.idn = idn;
        this.menu = menu;
        this.harga = harga;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getIdn() {
        return idn;
    }

    public void setIdn(int idn) {
        this.idn = idn;
    }
}
