package com.pamula.kasir.controller;

import android.content.Context;
import android.content.Intent;

import com.pamula.kasir.helper.Message;
import com.pamula.kasir.model.Food;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by DEKSTOP on 12/01/2017.
 */
public class FoodController {
    private static final String TAG = "***";

    private Realm realm;
    private RealmResults<Food> realmResults;
    private Context context;

    /**
     * constructor for created instance realm
     *
     * @param context
     */
    public FoodController(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        this.context = context;
    }


    public boolean store(final Food q) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(q);
            }
        });

        return true;
    }

    public void update(final int id, final String name, final String email, final String password) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Food food = realm.where(Food.class).equalTo("id", id).findFirst();
                food.setName(name);
                food.setCategory(email);
                food.setPrice(password);
            }
        });

    }

    public void delete(final int id) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // remove data in results
                RealmResults<Food> result = realm.where(Food.class).equalTo("id", id).findAll();
                result.deleteAllFromRealm();
            }
        });
    }

    /**
     * method for get all food
     */
    public ArrayList<Food> findAllFood() {
        ArrayList<Food> data = new ArrayList<>();

        realmResults = realm.where(Food.class).findAll();
        realmResults.sort("id", Sort.DESCENDING);

        if (realmResults.size() > 0) {
            data.addAll(realmResults);
        } else {
//                Helper.showLog("Size : 0");
//                Helper.showToast(context, "Database kosong !");
        }

        return data;
    }

    /**
     * method for get Food
     */
    public Food getFood() {
        Food Food = null;
        realmResults = realm.where(Food.class).findAllSorted("id", Sort.DESCENDING);
        if (realmResults.size() > 0) {
            Food = realmResults.first();
        }

        return Food;
    }

    /**
     * method for get Food
     */
    public Food findFood(int id) {
        Food food = null;
        food = realm.where(Food.class).equalTo("id", id).findFirst();
        return food;
    }

    /**
     * this method to check if Food.class is empty
     *
     * @return
     */
    public boolean hasFoods() {

        long size = realm.where(Food.class).count();
        if (size > 0) {
            return true;
        } else {
            return false;
        }

    }

    public RealmResults<Food> findCategory() {
        RealmResults<Food> result = realm.where(Food.class).distinct("category");

        return result;
    }

    public RealmResults<Food> findFoodBy(String ktg) {
        RealmResults<Food> result = realm.where(Food.class).equalTo("category", ktg).findAllSorted("name", Sort.ASCENDING);

        return result;
    }
}
