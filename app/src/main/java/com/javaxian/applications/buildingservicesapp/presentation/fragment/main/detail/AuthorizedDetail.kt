package com.javaxian.applications.buildingservicesapp.presentation.fragment.main.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.detail.presenter.AuthorizedDetailPresenterImpl
import com.javaxian.applications.buildingservicesapp.presentation.fragment.main.detail.presenter.IAuthorizedDetailPresenter
import kotlinx.android.synthetic.main.fragment_authorized_detail.*

class AuthorizedDetail : Fragment(), IAuthorizedDetailPresenter.View, View.OnClickListener{

    lateinit var presenter: AuthorizedDetailPresenterImpl


    var rootView: View? = null
    lateinit var paymentEntity: PaymentEntity

    companion object {
        fun newInstance(paymentEntity: PaymentEntity): AuthorizedDetail {

            var fragmentAuthorizedDetail =
                AuthorizedDetail()
            fragmentAuthorizedDetail.setHasOptionsMenu(true)
            fragmentAuthorizedDetail.paymentEntity = paymentEntity

            return fragmentAuthorizedDetail
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_authorized_detail, container, false);

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initResources()
    }

    private fun initPresenter(){
        presenter =
            AuthorizedDetailPresenterImpl()
        presenter.setView(this)
        presenter.setActivity(activity!!)
        presenter.setContext(context!!)
        presenter.initialize()
    }

    private fun initResources(){
        save_button.setOnClickListener(this)
        radio_authorized.setOnClickListener(this)
        radio_rejected.setOnClickListener(this)
    }

    override fun initView() {

            client_name.text = paymentEntity?.name
            date.text = "Fecha: "+ paymentEntity?.date
            amount.text = "$ " + paymentEntity?.amount.toString()
            dollars_amount.text = "$ " + ((paymentEntity!!.amount) * 21).toString()
            comission.text = "% " + paymentEntity?.commission.toString()
            payment_commission.text = "$ " + ((paymentEntity!!.amount) * (paymentEntity!!.commission)).toString()

            if (paymentEntity?.authorization == 0) {
                radio_authorized.isChecked = false
                radio_rejected.isChecked = true

            } else {
                radio_authorized.isChecked = true
                radio_rejected.isChecked = false
            }

            comment.setText(paymentEntity?.comment)



    }

    override fun showMessage(message: String) {
        Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View?) {
        when(view?.id){

            R.id.save_button -> validateAndUpdateFields()

            R.id.radio_authorized -> paymentEntity.authorization = 1

            R.id.radio_rejected -> paymentEntity.authorization = 0

        }
    }

    private fun validateAndUpdateFields(){
        val comment = comment.text.toString()

        if(comment.equals(null) && comment.equals("")){
            Toast.makeText(activity,"Necesitas agregar un comentario", Toast.LENGTH_LONG).show()
        }else{
            paymentEntity.comment = comment
            presenter.onUpdateData(paymentEntity)
        }
    }
}