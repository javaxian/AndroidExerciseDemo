package com.javaxian.applications.buildingservicesapp.presentation.fragment.splash.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter

interface ISplashPresenter {

    fun selectActivity()

    interface View : BasePresenter.View{

        fun startNextActivity(cls: Class<*>)
    }

}