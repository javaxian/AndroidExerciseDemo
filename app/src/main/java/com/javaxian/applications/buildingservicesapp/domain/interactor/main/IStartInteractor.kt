package com.javaxian.applications.buildingservicesapp.domain.interactor.main

import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponse

interface IStartInteractor {

    fun getInfoPayments(callback: BaseResponse)
}