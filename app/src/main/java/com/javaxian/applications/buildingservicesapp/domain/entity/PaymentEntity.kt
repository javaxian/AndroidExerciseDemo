package com.javaxian.applications.buildingservicesapp.domain.entity


import android.os.Parcel
import android.os.Parcelable

class   PaymentEntity : Parcelable {


    var id_client:Int = 0
    var name:String = ""
    var amount:Double = 0.0
    var commission:Int = 0
    var authorization:Int = 0
    var comment:String = ""
    var date:String = ""

    constructor()

    protected constructor(source:Parcel){
        id_client = source.readInt()
        name = source.readString()
        amount = source.readDouble()
        commission = source.readInt()
        authorization = source.readInt()
        comment = source.readString()
        date = source.readString()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            dest.writeInt(id_client)
            dest.writeString(name)
            dest.writeDouble(amount)
            dest.writeInt(commission)
            dest.writeInt(authorization)
            dest.writeString(comment)
            dest.writeString(date)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<PaymentEntity> = object : Parcelable.Creator<PaymentEntity>{
            override fun newArray(size: Int): Array<PaymentEntity?> = arrayOfNulls<PaymentEntity>(size)
            override fun createFromParcel(source: Parcel): PaymentEntity = PaymentEntity(source)
        }
    }



}