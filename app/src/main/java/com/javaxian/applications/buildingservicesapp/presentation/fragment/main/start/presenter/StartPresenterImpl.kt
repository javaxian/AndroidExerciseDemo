package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.start.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponse
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.IStartInteractor
import com.javaxian.applications.buildingservicesapp.domain.interactor.main.StartInteractorImpl
import java.util.ArrayList

class StartPresenterImpl : BasePresenter<IStartPresenter.View>(), IStartPresenter {

    private var interactor:IStartInteractor? = null

    override fun initialize() {
        super.initialize()

        interactor = StartInteractorImpl()
    }

    override fun onGetPayments() {

        getView()?.showProgressBar()
        getView()?.disableButton()

        interactor?.getInfoPayments(object : BaseResponse(){
            override fun onSuccess() {
                getView()?.hideProgressBar()
                getView()?.enableButton()
                getView()?.showResult("Información descargada correctamente")
            }

            override fun onError(e: Exception) {
                super.onError(e)
                getView()?.hideProgressBar()
                getView()?.enableButton()
                getView()?.showResult("Ocurrió un error al descargar información, intenta más tarde")
            }

        })

    }
}