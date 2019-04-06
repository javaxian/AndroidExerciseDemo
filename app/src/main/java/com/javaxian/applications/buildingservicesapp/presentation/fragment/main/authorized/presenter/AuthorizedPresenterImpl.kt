package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.authorized.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponseList
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.AuthorizedInteractorImpl
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.IAuthorizedInteractor
import java.util.ArrayList

class AuthorizedPresenterImpl : BasePresenter<IAuthorizedPresenter.View>(), IAuthorizedPresenter {

    private var interactor: IAuthorizedInteractor? = null

    override fun initialize() {
        super.initialize()

        interactor = AuthorizedInteractorImpl()
    }

    override fun onGetClients() {

         interactor?.getAuthorizedPayments(1, object : BaseResponseList<PaymentEntity>(){
             override fun onSuccess(payments: ArrayList<PaymentEntity>) {
                 getView()?.initView(payments)
             }
         })

    }
}