package com.javaxian.applications.buildingservicesapp.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.javaxian.applications.buildingservicesapp.R
import com.javaxian.applications.buildingservicesapp.domain.base.BaseHolder
import com.javaxian.applications.buildingservicesapp.domain.callback.OnItemRecyclerClickListener
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import kotlinx.android.synthetic.main.recycler_rejected_item.view.*

class RejectedRecycler (val data: ArrayList<PaymentEntity>, val listener: OnItemRecyclerClickListener<PaymentEntity>)
    : RecyclerView.Adapter<BaseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.recycler_rejected_item, parent, false)

        return ContentHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        var contentHolder: RejectedRecycler.ContentHolder = holder as RejectedRecycler.ContentHolder
        var dataItem = data[position]

        contentHolder.v.recycler_main_item_client_rejected.text = dataItem.name
        contentHolder.v.recycler_main_item_amount_rejected.text = dataItem.amount.toString()
        contentHolder.v.recycler_main_item_date_rejected.text = dataItem.date
    }

    inner class ContentHolder(val v: View): BaseHolder(v) {

        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            super.onClick(view)

            when(view?.id){
                R.id.client_view_item -> setOnclickListener()
            }
        }


        private fun setOnclickListener(){
            var paymentEntity: PaymentEntity = data.get(adapterPosition)
            listener.onItemRecyclerClick(view,adapterPosition,paymentEntity)
        }
    }
}