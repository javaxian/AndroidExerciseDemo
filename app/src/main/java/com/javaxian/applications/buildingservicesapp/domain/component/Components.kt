package com.javaxian.applications.buildingservicesapp.domain.component

import com.javaxian.applications.buildingservicesapp.data.model.operation.PaymentRealmRepositoryImpl
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.StartInteractorImpl
import com.javaxian.applications.buildingservicesapp.domain.module.RealmModule
import com.javaxian.applications.buildingservicesapp.domain.module.RetrofitModule
import com.javaxian.applications.buildingservicesapp.presentation.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetrofitModule::class, RealmModule::class))
interface Components {

    fun inject(target: StartInteractorImpl)
    fun inject(tarjet: PaymentRealmRepositoryImpl)
}