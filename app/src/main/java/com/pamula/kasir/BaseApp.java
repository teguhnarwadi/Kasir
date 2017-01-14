package com.pamula.kasir;

import android.app.Application;

import com.pamula.kasir.helper.SeederDB;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * Created by DEKSTOP on 12/01/2017.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // The Realm file will be located in Context.getFilesDir() with name "default.realm"
        Realm.init(this);

        // Configuration realm
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0) // Version database
                .initialData(new SeederDB())
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
