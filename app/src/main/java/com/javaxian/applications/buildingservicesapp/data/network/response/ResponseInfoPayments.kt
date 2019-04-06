package com.javaxian.applications.buildingservicesapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseInfoPayments (
    @SerializedName("code")
    @Expose
    val code:Int = 0,

    @SerializedName("message")
    @Expose
    val message:String = "",

    @SerializedName("payments")
    @Expose
    val payments:ArrayList<ResponsePayment> = ArrayList()
)