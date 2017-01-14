package com.pamula.kasir.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.pamula.kasir.R;
import com.pamula.kasir.adapter.Item;
import com.pamula.kasir.adapter.TwoTextArrayAdapter;

/**
 * Created by DEKSTOP on 13/01/2017.
 */
public class Header implements Item {

    private final String         name;

    public Header(String name) {
        this.name = name;
    }

    @Override
    public int getViewType() {
        return TwoTextArrayAdapter.RowType.HEADER_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.snippet_item2, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView text = (TextView) view.findViewById(R.id.textSeparator);
        text.setText(name);

        return view;
    }

}
