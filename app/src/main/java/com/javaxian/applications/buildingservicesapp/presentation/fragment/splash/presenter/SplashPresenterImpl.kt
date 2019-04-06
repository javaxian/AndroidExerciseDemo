package com.javaxian.applications.buildingservicesapp.presentation.fragment.splash.presenter

import android.os.Build
import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.presentation.activity.MainActivity

class SplashPresenterImpl : BasePresenter<ISplashPresenter.View>(), ISplashPresenter {


    override fun initialize() {
        super.initialize()
    }

    override fun selectActivity() {

        var splashThread = object : Thread() {
            override fun run() {

                sleep(2000)

                val cls = MainActivity::class.java

                if (getView() != null)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        //if need to request permission set here
                        getView()?.startNextActivity(cls)
                    } else {
                        getView()?.startNextActivity(cls)
                    }
            }
        }

        splashThread.start()
    }
}