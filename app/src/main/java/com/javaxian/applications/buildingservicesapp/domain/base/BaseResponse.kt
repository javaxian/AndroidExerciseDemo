package com.javaxian.applications.buildingservicesapp.domain.base

abstract class BaseResponse {

    abstract fun onSuccess()

    open fun onError(e: Exception) {}
}