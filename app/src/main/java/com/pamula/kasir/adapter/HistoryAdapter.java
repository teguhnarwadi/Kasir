package com.pamula.kasir.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.pamula.kasir.R;
import com.pamula.kasir.helper.util;
import com.pamula.kasir.model.Nota;

import java.util.List;

/**
 * Created by DEKSTOP on 14/01/2017.
 */
public class HistoryAdapter extends ArrayAdapter<Nota> {

    int x =0;
    int total=0;
    public HistoryAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public HistoryAdapter(Context context, int resource, List<Nota> items) {
        super(context, resource, items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            view = vi.inflate(R.layout.history_item, null);
        }

        TextView tv_nomor = (TextView) view.findViewById(R.id.tv_nomor);
        TextView tv_menu = (TextView) view.findViewById(R.id.tv_menu);
        TextView tv_total = (TextView) view.findViewById(R.id.tv_total);

        Nota n = getItem(position);

        tv_nomor.setText("Nota No. " + n.getIdn());
        tv_menu.setText(n.getMenu() + "  \t\tRp. " + n.getHarga() + " x\t\t" + n.getQty() + "\n");


        return view;
    }
}
