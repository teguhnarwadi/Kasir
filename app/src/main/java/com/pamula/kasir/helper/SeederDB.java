package com.pamula.kasir.helper;

import com.pamula.kasir.model.Food;
import com.pamula.kasir.model.User;

import io.realm.Realm;

/**
 * Created by DEKSTOP on 12/01/2017.
 */
public class SeederDB implements Realm.Transaction {
    @Override
    public void execute(Realm realm) {
        User user = new User(1, "admin", "admin");
        realm.copyToRealm(user);

        Food food = new Food(1, "Ayam Goreng", "Makanan", "10000", null);
        realm.copyToRealm(food);
        Food food2 = new Food(2, "Ayam Bakar", "Makanan", "10000", null);
        realm.copyToRealm(food2);
        Food food3 = new Food(3, "Ayam Kukus", "Makanan", "10000", null);
        realm.copyToRealm(food3);
        Food food4 = new Food(4, "Es Jeruk", "Minuman", "3000", null);
        realm.copyToRealm(food4);
        Food food5 = new Food(5, "Es Teh", "Minuman", "2000", null);
        realm.copyToRealm(food5);
    }
}
