package com.javaxian.applications.buildingservicesapp.data.repository.mapper

import com.javaxian.applications.buildingservicesapp.data.model.entity.PaymentRealm
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity

class PaymentMapper : Mapper<PaymentRealm, PaymentEntity>() {

    override fun map(value: PaymentRealm): PaymentEntity {

       var paymentEntity =  PaymentEntity()

        paymentEntity.id_client = value.id_client
        paymentEntity.amount = value.amount
        paymentEntity.authorization = value.authorization
        paymentEntity.comment = value.comment
        paymentEntity.commission = value.commission
        paymentEntity.date = value.date
        paymentEntity.name = value.name

        return paymentEntity
    }

    override fun reverseMap(value: PaymentEntity): PaymentRealm {

        var paymentRealm = PaymentRealm()

        paymentRealm.id_client = value.id_client
        paymentRealm.amount = value.amount
        paymentRealm.authorization = value.authorization
        paymentRealm.comment = value.comment
        paymentRealm.commission = value.commission
        paymentRealm.date = value.date
        paymentRealm.name = value.name

        return paymentRealm
    }


}