package com.javaxian.applications.buildingservicesapp.domain.interactor.main

import android.util.Log
import com.javaxian.applications.buildingservicesapp.Application
import com.javaxian.applications.buildingservicesapp.data.network.IWebServices
import com.javaxian.applications.buildingservicesapp.data.network.response.ResponseInfoPayments
import com.javaxian.applications.buildingservicesapp.data.network.response.ResponsePayment
import com.javaxian.applications.buildingservicesapp.data.repository.implementation.PaymentDataRepositoryImpl
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponse
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.utils.DebugUtils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.lang.Exception
import java.util.*
import javax.inject.Inject

class StartInteractorImpl : IStartInteractor {

    @Inject
    lateinit var retrofit: Retrofit

    private var repository: PaymentDataRepositoryImpl = PaymentDataRepositoryImpl()

    init {
        Application.getInstance()?.getComponents()?.inject(this)
    }

    override fun getInfoPayments(callback: BaseResponse) {

        val request : Observable<ResponseInfoPayments> = retrofit.create(IWebServices::class.java).getInfoPayments();

        request.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseInfoPayments> {

                internal var payments = ArrayList<PaymentEntity>()
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(response: ResponseInfoPayments) {

                    DebugUtils.logDebug("StartInteractor: onNext")

                    for (responsePayment in response.payments) {
                        val payment = PaymentEntity()

                        payment.id_client = responsePayment.id_client
                        payment.name = responsePayment.name
                        payment.amount = responsePayment.amount
                        payment.commission = responsePayment.commission
                        payment.authorization = responsePayment.authorization
                        payment.comment = responsePayment.comment
                        payment.date = responsePayment.date

                        payments.add(payment)

                    }

                }

                override fun onError(e: Throwable) {
                    DebugUtils.logDebug("StartInteractor: onError" + e.message)
                    callback.onError(Exception(e.message))
                }

                override fun onComplete() {
                    DebugUtils.logDebug("StartInteractor: onComplete")
                    repository.create(payments)
                    callback.onSuccess()
                }
            })
    }
}