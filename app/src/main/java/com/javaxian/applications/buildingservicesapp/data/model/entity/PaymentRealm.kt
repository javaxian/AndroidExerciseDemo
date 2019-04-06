package com.javaxian.applications.buildingservicesapp.data.model.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class PaymentRealm : RealmObject() {

    @PrimaryKey
    var id_client:Int = 0
    var name:String = ""
    var amount:Double = 0.0
    var commission:Int = 0
    var authorization:Int = 0
    var comment:String = ""
    var date:String = ""



}