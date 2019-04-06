package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.rejected.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponseList
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.AuthorizedInteractorImpl
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.IAuthorizedInteractor
import java.util.*

class RejectedPresenterImpl : BasePresenter<IRejectedPresenter.View>(), IRejectedPresenter {

    private var interactor: IAuthorizedInteractor? = null

    override fun initialize() {
        super.initialize()

        interactor = AuthorizedInteractorImpl()
    }

    override fun onGetClients() {

        interactor?.getAuthorizedPayments(0, object : BaseResponseList<PaymentEntity>(){
            override fun onSuccess(payments: ArrayList<PaymentEntity>) {
                getView()?.initView(payments)
            }
        })
    }
}