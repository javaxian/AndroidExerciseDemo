package com.javaxian.applications.buildingservicesapp.presentation.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.domain.callback.OnFragmentChangedListener
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.authorized.AuthorizedFragment
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.rejected.RejectedFragment
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.start.StartFragment

class MainActivity : AppCompatActivity(), OnFragmentChangedListener{



    lateinit var toolbar: ActionBar
    lateinit var mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!

        initiResources()
    }

    private fun initiResources(){

        mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.start_item -> {
                    toolbar.title = "Inicio"
                    onFragmentChanged(StartFragment.newInstance(null), R.id.container)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.authorized_item -> {
                    toolbar.title = "Pagos Autorizados"
                    onFragmentChanged(AuthorizedFragment.newInstance(null), R.id.container)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.rejected_item -> {
                    toolbar.title = "Pagos Rechazados"
                    onFragmentChanged(RejectedFragment.newInstance(null), R.id.container)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigationView.selectedItemId = R.id.start_item

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
