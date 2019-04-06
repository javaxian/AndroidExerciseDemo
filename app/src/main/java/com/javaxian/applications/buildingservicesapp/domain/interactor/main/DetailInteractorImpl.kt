package com.javaxian.applications.buildingservicesapp.domain.interactor.main

import com.javaxian.applications.buildingservicesapp.data.repository.implementation.PaymentDataRepositoryImpl
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponse
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

class DetailInteractorImpl : IDetailInteractor {

    private var repository: PaymentDataRepositoryImpl = PaymentDataRepositoryImpl()

    override fun updatePayment(paymentEntity: PaymentEntity, callback: BaseResponse) {
        repository.update(paymentEntity)
        callback.onSuccess()
    }


}