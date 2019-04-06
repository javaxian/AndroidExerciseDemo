package com.javaxian.applications.buildingservicesapp.data.repository.implementation

import com.javaxian.applications.buildingservicesapp.data.model.operation.PaymentRealmRepositoryImpl
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.domain.repository.IPaymentRepository

class PaymentDataRepositoryImpl : IPaymentRepository{

    internal var repository: IPaymentRepository = PaymentRealmRepositoryImpl()

    override fun create(paymentEntity: PaymentEntity) {
        repository.create(paymentEntity)
    }

    override fun create(paymentEntities: ArrayList<PaymentEntity>) {
        repository.create(paymentEntities)
    }

    override fun read(client_id: Int): PaymentEntity {
        return repository.read(client_id)
    }

    override fun update(paymentEntity: PaymentEntity) {
        repository.update(paymentEntity)
    }

    override fun update(paymentEntities: ArrayList<PaymentEntity>) {
        repository.update(paymentEntities)
    }

    override fun readAll(): ArrayList<PaymentEntity> {
        return repository.readAll()
    }

    override fun readAllByAuthorization(authorization: Int): ArrayList<PaymentEntity> {
        return repository.readAllByAuthorization(authorization)
    }


}