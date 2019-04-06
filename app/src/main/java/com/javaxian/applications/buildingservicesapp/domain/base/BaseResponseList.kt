package com.javaxian.applications.buildingservicesapp.domain.base

import java.util.ArrayList

abstract class BaseResponseList<T> {

    abstract fun onSuccess(objList: ArrayList<T>)

    open fun onError(e: Exception, msg: String) {}
}