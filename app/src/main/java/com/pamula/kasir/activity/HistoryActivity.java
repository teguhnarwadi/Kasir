package com.pamula.kasir.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pamula.kasir.R;
import com.pamula.kasir.adapter.HistoryAdapter;
import com.pamula.kasir.controller.NotaController;
import com.pamula.kasir.model.Nota;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private int x = 0;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        NotaController controller = new NotaController(HistoryActivity.this);
        ArrayList<Nota> notas = controller.findAllNota();

        Log.d("*eee", notas.toString());
        Log.d("*eee", notas.toArray().toString());

        // Get ListView object from xml
        ListView listView = (ListView) findViewById(R.id.list);

        HistoryAdapter adapter = new HistoryAdapter(this,
                R.layout.history_item, notas);

        listView.setAdapter(adapter);


    }
}
