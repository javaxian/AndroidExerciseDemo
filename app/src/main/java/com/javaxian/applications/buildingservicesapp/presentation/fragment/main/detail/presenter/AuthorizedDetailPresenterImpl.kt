package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.detail.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponse
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.DetailInteractorImpl
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.IDetailInteractor

class AuthorizedDetailPresenterImpl : BasePresenter<IAuthorizedDetailPresenter.View>(),
    IAuthorizedDetailPresenter {

    private var interactor: IDetailInteractor? = null

    override fun initialize() {
        super.initialize()
        getView()?.initView()

        interactor = DetailInteractorImpl()
    }

    override fun onUpdateData(paymentEntity: PaymentEntity) {

        interactor?.updatePayment(paymentEntity, object : BaseResponse(){
            override fun onSuccess() {
                getView()?.showMessage("Se guardo la información correctamente")
            }

            override fun onError(e: Exception) {
                super.onError(e)
                getView()?.showMessage("Ocurrio un problema al guardar la información, intenta más tarde")
            }

        })
    }
}