package com.pamula.kasir.activity.menu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;

import com.pamula.kasir.R;
import com.pamula.kasir.activity.MainActivity;
import com.pamula.kasir.controller.FoodController;
import com.pamula.kasir.adapter.Header;
import com.pamula.kasir.adapter.Item;
import com.pamula.kasir.adapter.ListItem;
import com.pamula.kasir.adapter.TwoTextArrayAdapter;
import com.pamula.kasir.model.Food;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

public class DaftarActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarActivity.this, CreateActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        FoodController controller = new FoodController(DaftarActivity.this);
        ArrayList<Food> list = controller.findAllFood();

        RealmResults<Food> ctg = controller.findCategory();
        Log.d("***", String.valueOf(ctg.size()));

        List<Item> items = new ArrayList<Item>();

        TwoTextArrayAdapter adapter = new TwoTextArrayAdapter(this, items);

        for (int i = 0; i < ctg.size(); i++) {

            Food ktg = ctg.get(i);
            items.add(new Header(ktg.getCategory()));
            Log.d("*** Ktg", String.valueOf(ktg.getCategory()));

            RealmResults<Food> food = controller.findFoodBy(ktg.getCategory());
            for (int ii = 0; ii < food.size(); ii++) {
                Log.d("*** Menu", String.valueOf(food.get(ii).getName()));
                items.add(new ListItem(adapter, food, food.get(ii).getId(), food.get(ii).getName(), food.get(ii).getPrice()));
            }
        }

        setListAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DaftarActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

}
