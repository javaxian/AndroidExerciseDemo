package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.detail.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter
import com.javaxian.applications.buildingservicesapp.domain.base.BaseResponse
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

interface IAuthorizedDetailPresenter {

    fun onUpdateData(paymentEntity: PaymentEntity)

    interface View : BasePresenter.View{

        fun initView()
        fun showMessage(message:String)
    }
}