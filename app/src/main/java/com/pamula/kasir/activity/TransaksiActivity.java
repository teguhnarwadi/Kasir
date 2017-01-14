package com.pamula.kasir.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pamula.kasir.R;
import com.pamula.kasir.adapter.Header;
import com.pamula.kasir.adapter.Item;
import com.pamula.kasir.adapter.ListItemTransaksi;
import com.pamula.kasir.adapter.TransaksiAdapter;
import com.pamula.kasir.controller.FoodController;
import com.pamula.kasir.controller.NotaController;
import com.pamula.kasir.helper.util;
import com.pamula.kasir.model.Food;
import com.pamula.kasir.model.Nota;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.RealmResults;

public class TransaksiActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        FoodController controller = new FoodController(TransaksiActivity.this);
        ArrayList<Food> list = controller.findAllFood();

        RealmResults<Food> ctg = controller.findCategory();

        List<Item> items = new ArrayList<Item>();

        TransaksiAdapter adapter = new TransaksiAdapter(this, items);

        for (int i = 0; i < ctg.size(); i++) {

            Food ktg = ctg.get(i);
            items.add(new Header(ktg.getCategory()));

            RealmResults<Food> food = controller.findFoodBy(ktg.getCategory());
            for (int ii = 0; ii < food.size(); ii++) {
                items.add(new ListItemTransaksi(food.get(ii).getId(), food.get(ii).getName(), food.get(ii).getPrice()));
            }
        }

        setListAdapter(adapter);

        final TextView textView = (TextView) findViewById(R.id.total);

        Button button = (Button) findViewById(R.id.button_simpan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotaController nota = new NotaController(TransaksiActivity.this);
                FoodController food = new FoodController(TransaksiActivity.this);

                int idn = nota.findIdNota();

                for(Map.Entry<Integer, Integer> entry : util.tttt.entrySet()) {
                    int id = (int) (System.currentTimeMillis() / 1000);
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();

                    Food f = food.findFood(key);
                    Nota n = new Nota(id, idn, f.getName(), f.getPrice(), value);
                    nota.store(n);

                }

                Intent intent = new Intent(TransaksiActivity.this, TransaksiActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            }
        });

        Button button2 = (Button) findViewById(R.id.button_hitung);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FoodController food = new FoodController(TransaksiActivity.this);

                int total = 0;

                for(Map.Entry<Integer, Integer> entry : util.tttt.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();

                    Food f = food.findFood(key);
                    total += Integer.parseInt(f.getPrice()) * value;
                    Log.d("*tot", String.valueOf(total));
                }

                Log.d("*tot", String.valueOf(total));
                textView.setText(""+total);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TransaksiActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
