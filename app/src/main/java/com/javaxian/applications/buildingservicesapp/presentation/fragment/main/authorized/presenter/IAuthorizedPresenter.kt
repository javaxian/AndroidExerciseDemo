package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.authorized.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

interface IAuthorizedPresenter {

    fun onGetClients()

    interface View : BasePresenter.View{

        fun initView(clients: ArrayList<PaymentEntity>)
    }
}