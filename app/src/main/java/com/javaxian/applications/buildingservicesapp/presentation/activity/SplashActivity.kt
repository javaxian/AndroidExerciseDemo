package com.javaxian.applications.buildingservicesapp.presentation.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.presentation.fragment.splash.SplashFragment

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initFragment()
    }

    private fun initFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, SplashFragment.newInstance(null))
            .commit()
    }

}