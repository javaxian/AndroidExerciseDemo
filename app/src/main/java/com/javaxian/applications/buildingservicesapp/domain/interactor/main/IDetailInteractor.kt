package com.javaxian.applications.buildingservicesapp.domain.interactor.main

import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponse
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

interface IDetailInteractor {

    fun updatePayment(paymentEntity: PaymentEntity,callback: BaseResponse)

}