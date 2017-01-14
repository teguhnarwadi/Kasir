package com.pamula.kasir.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pamula.kasir.R;
import com.pamula.kasir.activity.menu.DaftarActivity;
import com.pamula.kasir.activity.menu.EditActivity;
import com.pamula.kasir.adapter.Item;
import com.pamula.kasir.adapter.TwoTextArrayAdapter;
import com.pamula.kasir.controller.FoodController;
import com.pamula.kasir.model.Food;

import io.realm.RealmResults;

/**
 * Created by DEKSTOP on 13/01/2017.
 */
public class ListItem implements Item {

    private final int            id;
    private final String         str1;
    private final String         str2;
    private TwoTextArrayAdapter adapter;
    private RealmResults<Food> food;

    public ListItem(TwoTextArrayAdapter adapter, RealmResults<Food> food, int id, String text1, String text2) {
        this.food = food;
        this.adapter = adapter;
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
            view = (View) inflater.inflate(R.layout.snippet_item1, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView text1 = (TextView) view.findViewById(R.id.textView_menu);
        TextView text2 = (TextView) view.findViewById(R.id.textView_harga);
        Button button1 = (Button) view.findViewById(R.id.button_edit);
        Button button2 = (Button) view.findViewById(R.id.button_delete);
        text1.setText(str1);
        text2.setText(str2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(view.getContext(), "edit "+id, Toast.LENGTH_LONG).show();

                Bundle bundle = new Bundle();
                bundle.putInt("id", id);

                Intent intent = new Intent(view.getContext(), EditActivity.class);
                intent.putExtras(bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                view.getContext().startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(view.getContext(), "hapus "+id, Toast.LENGTH_LONG).show();
                FoodController controller = new FoodController(view.getContext());
                controller.delete(id);

                Intent refresh = new Intent(view.getContext(), DaftarActivity.class);
                refresh.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                view.getContext().startActivity(refresh);//Start the same Activity

            }
        });

        return view;
    }

}
