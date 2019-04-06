package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.rejected.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

interface IRejectedPresenter {

    fun onGetClients()

    interface View : BasePresenter.View{

        fun initView(clients: ArrayList<PaymentEntity>)
    }
}