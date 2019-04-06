package com.javaxian.applications.buildingservicesapp.domain.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
class RealmModule {

    private var realm: Realm? = null
    private var realmConfig: RealmConfiguration? = null


    constructor(context: Context){
        initRealm(context)
    }

    @Synchronized
    private fun initRealm(context: Context) {
        Realm.init(context)
        Realm.setDefaultConfiguration(getRealmConfig())
    }


    fun getRealm(): Realm? {

        if (realm == null) {
            realm = Realm.getInstance(getRealmConfig())
        } else if (realm!!.isClosed()) {
            realm = Realm.getInstance(getRealmConfig())
        }

        return realm
    }

    @Provides
    fun getRealmModule(): RealmModule {
        return this
    }

    @Synchronized
    private fun getRealmConfig(): RealmConfiguration? {
        if (realmConfig == null)
            realmConfig = RealmConfiguration.Builder()
                .name("payments.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()

        return realmConfig
    }


}