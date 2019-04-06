package com.javaxian.applications.buildingservicesapp.presentation.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.domain.callback.OnFragmentChangedListener
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.detail.AuthorizedDetail

class DetailActivity : AppCompatActivity(), OnFragmentChangedListener {

    lateinit var toolbar: ActionBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        toolbar = supportActionBar!!
        initFragment()
    }


    private fun initFragment(){

        toolbar.title = "Información de Pago"

        val detailEntity:Any = intent.extras.getParcelable("object_id")
        lateinit var fragment:Fragment

        if(detailEntity is PaymentEntity){
            fragment = AuthorizedDetail.newInstance(detailEntity)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onFragmentChanged(fragment: Fragment, container: Int) {
        supportFragmentManager
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(container, fragment, fragment.javaClass.name)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }


}