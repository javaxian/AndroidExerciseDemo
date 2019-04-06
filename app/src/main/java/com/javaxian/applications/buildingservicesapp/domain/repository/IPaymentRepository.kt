package com.javaxian.applications.buildingservicesapp.domain.repository

import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

interface IPaymentRepository {

    fun create(paymentEntity:PaymentEntity)

    fun create(paymentEntities:ArrayList<PaymentEntity>)

    fun read(client_id:Int):PaymentEntity

    fun update(paymentEntity: PaymentEntity)

    fun update(paymentEntities:ArrayList<PaymentEntity>)

    fun readAll():ArrayList<PaymentEntity>

    fun readAllByAuthorization(authorization:Int):ArrayList<PaymentEntity>

}