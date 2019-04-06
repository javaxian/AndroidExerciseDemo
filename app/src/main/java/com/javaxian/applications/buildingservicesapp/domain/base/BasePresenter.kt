package com.javaxian.applications.buildingservicesapp.domain.base

import android.app.Activity
import android.content.Context

open class BasePresenter<T> {

    private var view: T? = null
    private var context: Context? = null
    private var activity: Activity? = null

    fun getView(): T? {
        return view
    }

    fun setView(view: T) {
        this.view = view
    }

    fun getContext(): Context? {
        return context
    }

    fun setContext(context: Context) {
        this.context = context
    }

    fun getActivity(): Activity? {
        return activity
    }

    fun setActivity(activity: Activity) {
        this.activity = activity
    }

    open fun initialize() {

    }


    interface View {

    }

}