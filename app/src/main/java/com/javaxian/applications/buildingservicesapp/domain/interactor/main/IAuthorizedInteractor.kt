package com.javaxian.applications.buildingservicesapp.domain.interactor.main

import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponseList
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

interface IAuthorizedInteractor {

    fun getAuthorizedPayments(option: Int, callback: BaseResponseList<PaymentEntity>)
}