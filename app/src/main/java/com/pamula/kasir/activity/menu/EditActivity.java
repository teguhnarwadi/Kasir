package com.pamula.kasir.activity.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pamula.kasir.R;
import com.pamula.kasir.activity.MainActivity;
import com.pamula.kasir.controller.FoodController;
import com.pamula.kasir.helper.Message;
import com.pamula.kasir.model.Food;

public class EditActivity extends AppCompatActivity {

    private String menu;
    private String kategori;
    private String harga;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigation_up);
        setSupportActionBar(toolbar);

        final EditText etMenu = (EditText) findViewById(R.id.editText_menu);
        final EditText etKtg = (EditText) findViewById(R.id.editText_kategori);
        final EditText etHarga = (EditText) findViewById(R.id.editText_harga);
        Button btnSave = (Button) findViewById(R.id.button_simpan);
        Button btnBatal = (Button) findViewById(R.id.button_batal);

        // get the Intent that started this Activity
        Intent intent = getIntent();
        // get the Bundle that stores the data of this Activity
        Bundle bundle = intent.getExtras();

        final int id = bundle.getInt("id");

        FoodController controller = new FoodController(EditActivity.this);
        Food food = controller.findFood(id);
        etMenu.setText(food.getName());
        etKtg.setText(food.getCategory());
        etHarga.setText(food.getPrice());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etMenu.getText().toString().matches("")) {
                    Message.showToast(EditActivity.this, "Enter Menu");
                } else if (etKtg.getText().toString().matches("")) {
                    Message.showToast(EditActivity.this, "Enter Kategory");
                } else if (etHarga.getText().toString().matches("")) {
                    Message.showToast(EditActivity.this, "Enter Harga");
                } else {
                    menu = etMenu.getText().toString();
                    kategori = etKtg.getText().toString();
                    harga = etHarga.getText().toString();

                    FoodController food = new FoodController(EditActivity.this);
                    food.update(id, menu, kategori, harga);

                    Intent intent = new Intent(EditActivity.this, DaftarActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, DaftarActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the toolbar navigation up
            case android.R.id.home:
                //Navigation icon
                Intent intent = new Intent(EditActivity.this, DaftarActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EditActivity.this, DaftarActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
