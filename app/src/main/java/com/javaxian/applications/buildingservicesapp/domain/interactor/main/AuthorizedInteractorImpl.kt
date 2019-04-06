package com.javaxian.applications.buildingservicesapp.domain.interactor.main

import com.javaxian.applications.buildingservicesapp.data.repository.implementation.PaymentDataRepositoryImpl
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponseList
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

class AuthorizedInteractorImpl : IAuthorizedInteractor{

    private var repository: PaymentDataRepositoryImpl = PaymentDataRepositoryImpl()

    override fun getAuthorizedPayments(option: Int, callback: BaseResponseList<PaymentEntity>) {
        var payments = repository.readAllByAuthorization(option)

        if (payments!=null){
            callback.onSuccess(payments)
        }
    }

}