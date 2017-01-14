package com.pamula.kasir.model;

/**
 * Created by DEKSTOP on 14/01/2017.
 */
public class Temp {
    private int id;
    private String menu;
    private String harga;
    private int qty;

    public Temp() {}

    public Temp(int id, String menu, String harga, int qty) {
        this.id = id;
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
}
