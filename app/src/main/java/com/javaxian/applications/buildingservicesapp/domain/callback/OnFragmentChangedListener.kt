package com.javaxian.applications.buildingservicesapp.domain.callback

import android.support.v4.app.Fragment

interface OnFragmentChangedListener {

    fun onFragmentChanged(fragment: Fragment, container: Int)

}