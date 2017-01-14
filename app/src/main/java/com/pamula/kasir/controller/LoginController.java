package com.pamula.kasir.controller;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.pamula.kasir.activity.MainActivity;
import com.pamula.kasir.helper.Message;
import com.pamula.kasir.model.User;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by DEKSTOP on 12/01/2017.
 */
public class LoginController {
    private static final String TAG = "***";

    private Realm realm;
    private RealmResults<User> realmResults;
    private Context context;

    /**
     * constructor for created instance realm
     *
     * @param context
     */
    public LoginController(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        this.context = context;
    }

    public boolean store(final User q) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(q);
            }
        });

        return true;
    }

    public boolean login(final String username, final String password) {
        User user = realm.where(User.class).findFirst();
        String dataUsername = user.getUsername();
        String dataPassword = user.getPassword();
        if (TextUtils.equals(username, dataUsername)) {
            if (TextUtils.equals(password, dataPassword)) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            } else {
                Message.showToast(context, "Password not match");
                return false;
            }
        } else {
            Message.showToast(context, "Username not match");
            return false;
        }
        return true;
    }
}
