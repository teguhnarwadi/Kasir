package com.pamula.kasir.controller;

import android.content.Context;
import android.util.Log;

import com.pamula.kasir.helper.Message;
import com.pamula.kasir.model.Food;
import com.pamula.kasir.model.Nota;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by DEKSTOP on 13/01/2017.
 */
public class NotaController {

    private static final String TAG = "***";

    private Realm realm;
    private RealmResults<Nota> realmResults;
    private Context context;

    /**
     * constructor for created instance realm
     *
     * @param context
     */
    public NotaController(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        this.context = context;
    }


    public boolean store(final Nota q) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(q);
            }
        });

        return true;
    }


    public ArrayList<Nota> findAllNota() {
        ArrayList<Nota> data = new ArrayList<>();

        realmResults = realm.where(Nota.class).findAll();
        realmResults.sort("id", Sort.DESCENDING);

        if (realmResults.size() > 0) {
            data.addAll(realmResults);
        } else {
            Message.showToast(context, "Database kosong !");
        }

        return data;
    }

    public int findIdNota() {
        int id = 1;
        realmResults = realm.where(Nota.class).findAll();

        if (!realmResults.isEmpty()) {
            Nota aa = realmResults.sort("idn", Sort.ASCENDING).first();
            Log.d("*aa", String.valueOf(aa.getIdn()));
            if (aa.getIdn() > 0) {
                id += 1;
            } else {
                id = 1;
            }
        }

        return id;
    }
}
