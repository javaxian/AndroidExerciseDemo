package com.javaxian.applications.buildingservicesapp.data.model.operation

import com.javaxian.applications.buildingservicesapp.Application
import com.javaxian.applications.buildingservicesapp.data.model.entity.PaymentRealm
import com.javaxian.applications.buildingservicesapp.data.repository.mapper.PaymentMapper
import com.javaxian.applications.buildingservicesapp.domain.entity.PaymentEntity
import com.javaxian.applications.buildingservicesapp.domain.module.RealmModule
import com.javaxian.applications.buildingservicesapp.domain.repository.IPaymentRepository
import io.realm.Realm
import javax.inject.Inject

class PaymentRealmRepositoryImpl : IPaymentRepository {

    @Inject
    lateinit var realmModule: RealmModule

    var realm: Realm? = null

    val mapper:PaymentMapper = PaymentMapper()

    init {
        Application.getInstance()?.getComponents()?.inject(this)

    }

    override fun create(paymentEntity: PaymentEntity) {
        realm = realmModule.getRealm()
        realm?.beginTransaction()
        realm?.copyToRealmOrUpdate(mapper.reverseMap(paymentEntity))
        realm?.commitTransaction()
        realm?.close()
    }

    override fun create(paymentEntities: ArrayList<PaymentEntity>) {
        realm = realmModule.getRealm()
        realm?.beginTransaction()
        realm?.copyToRealmOrUpdate(mapper.reverseMap(paymentEntities))
        realm?.commitTransaction()
        realm?.close()
    }

    override fun read(client_id: Int): PaymentEntity {
        realm = realmModule.getRealm()
        realm?.beginTransaction()
        val payment = realm?.where(PaymentRealm::class.java)?.equalTo("id_client", client_id)?.findFirst()
        realm?.commitTransaction()
        realm?.close()

        return mapper.map(payment!!)
    }

    override fun update(paymentEntity: PaymentEntity) {
        realm = realmModule.getRealm()
        realm?.beginTransaction()
        realm?.copyToRealmOrUpdate(mapper.reverseMap(paymentEntity))
        realm?.commitTransaction()
        realm?.close()
    }

    override fun update(paymentEntities: ArrayList<PaymentEntity>) {
        realm = realmModule.getRealm()
        realm?.beginTransaction()
        realm?.copyToRealmOrUpdate(mapper.reverseMap(paymentEntities))
        realm?.commitTransaction()
        realm?.close()
    }

    override fun readAll(): ArrayList<PaymentEntity> {
        realm = realmModule.getRealm()
        realm?.beginTransaction()
        val payments = realm?.where(PaymentRealm::class.java)?.findAll()
        realm?.commitTransaction()
        val paymentEntities = mapper.map(payments)
        realm?.close()

        return paymentEntities
    }

    override fun readAllByAuthorization(authorization: Int): ArrayList<PaymentEntity> {
        realm = realmModule.getRealm()
        realm?.beginTransaction()
        val payments = realm?.where(PaymentRealm::class.java)?.equalTo("authorization",authorization)?.findAll()
        realm?.commitTransaction()
        val paymentEntities = mapper.map(payments)
        realm?.close()

        return paymentEntities
    }
}