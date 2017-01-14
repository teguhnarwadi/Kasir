package com.pamula.kasir.adapter;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by DEKSTOP on 13/01/2017.
 */
public interface Item {
    public int getViewType();

    public View getView(LayoutInflater inflater, View convertView);
}
