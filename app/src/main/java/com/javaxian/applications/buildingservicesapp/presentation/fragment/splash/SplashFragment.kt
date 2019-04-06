package com.javaxian.applications.buildingservicesapp.presentation.fragment.splash

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.presentation.fragment.splash.presenter.ISplashPresenter
import com.javaxian.applications.buildingservicesapp.presentation.fragment.splash.presenter.SplashPresenterImpl

class SplashFragment : Fragment(), ISplashPresenter.View  {

    lateinit var presenter: SplashPresenterImpl

    var rootView: View? = null

    companion object {
        fun newInstance(args: Bundle?):SplashFragment{

            var fragmentSplash = SplashFragment()
            fragmentSplash.setHasOptionsMenu(true)
            fragmentSplash.arguments = args

            return fragmentSplash
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_splash, container, false);

        initPresenter()
        initResources()

        return rootView

    }

    fun initPresenter(){
        presenter = SplashPresenterImpl()
        presenter.setView(this)
        presenter.setActivity(activity!!)
        presenter.setContext(context!!)
        presenter.initialize()
        presenter.selectActivity()
    }

    fun initResources(){

    }


    override fun startNextActivity(cls: Class<*>) {
        val intent = Intent(activity, cls)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}