package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.start.presenter

import com.javaxian.applications.buildingservicesapp.domain.base.BasePresenter

interface IStartPresenter {

    fun onGetPayments()

    interface View : BasePresenter.View{

        fun initView()

        fun hideProgressBar()

        fun showProgressBar()

        fun enableButton()

        fun disableButton()

        fun showResult(message:String)
    }

}