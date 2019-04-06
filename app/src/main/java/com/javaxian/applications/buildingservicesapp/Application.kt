package com.javaxian.applications.buildingservicesapp

import android.support.multidex.MultiDexApplication
import com.javaxian.applications.buildingservicesapp.domain.component.Components
import com.javaxian.applications.buildingservicesapp.domain.component.DaggerComponents
import com.javaxian.applications.buildingservicesapp.domain.module.RealmModule
import com.javaxian.applications.buildingservicesapp.domain.module.RetrofitModule

class Application : MultiDexApplication() {

    private var components: Components? = null

    override fun onCreate() {
        super.onCreate()
        instance = this

        components = DaggerComponents.builder()
            .realmModule(RealmModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }

    fun getComponents(): Components? {
        return components
    }

    companion object {
        private var instance: Application? = null

        fun getInstance(): Application? {
            return instance
        }
    }



}