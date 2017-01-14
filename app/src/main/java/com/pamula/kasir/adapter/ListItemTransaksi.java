package com.pamula.kasir.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pamula.kasir.R;
import com.pamula.kasir.helper.util;

/**
 * Created by DEKSTOP on 13/01/2017.
 */
public class ListItemTransaksi implements Item {
    private final int id;
    private final String str1;
    private final String str2;
    int qty = 0;

    public ListItemTransaksi(int id, String text1, String text2) {
        this.id = id;
        this.str1 = text1;
        this.str2 = text2;
    }

    @Override
    public int getViewType() {
        return TwoTextArrayAdapter.RowType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        final View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.transaksi_item, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView text1 = (TextView) view.findViewById(R.id.textView_menu);
        TextView text2 = (TextView) view.findViewById(R.id.textView_harga);
        final TextView textQty = (TextView) view.findViewById(R.id.textView_qty);
        Button button1 = (Button) view.findViewById(R.id.button_plus);
        Button button2 = (Button) view.findViewById(R.id.button_min);
        text1.setText(str1);
        text2.setText(str2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final boolean b = util.tttt.containsKey(id);
                Log.d("*b", String.valueOf(b));

                if (b) {
                    qty = util.tttt.get(id);
                } else {
                    qty = 0;
                }

                qty += 1;

                util.tttt.put(id, qty);

                Log.d("*Id", String.valueOf(id));
                Log.d("*Qty", String.valueOf(qty));
                textQty.setText("" + qty);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final boolean b = util.tttt.containsKey(id);
                Log.d("*b", String.valueOf(b));

                if (b) {
                    qty = util.tttt.get(id);
                } else {
                    qty = 0;
                }

                if (qty != 0) {
                    qty -= 1;

                    util.tttt.put(id, qty);

                    Log.d("*Id", String.valueOf(id));
                    Log.d("*Qty", String.valueOf(qty));
                    textQty.setText("" + qty);
                }

            }
        });

        return view;
    }
}
