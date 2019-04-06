package com.javaxian.applications.buildingservicesapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponsePayment(
    @SerializedName("id_client")
    @Expose
    val id_client:Int = 0,

    @SerializedName("name")
    @Expose
    val name:String = "",

    @SerializedName("amount")
    @Expose
    val amount:Double = 0.0,

    @SerializedName("commission")
    @Expose
    val commission:Int = 0,

    @SerializedName("authorization")
    @Expose
    val authorization:Int = 0,

    @SerializedName("comment")
    @Expose
    val comment:String = "",

    @SerializedName("date")
    @Expose
    val date:String = ""
)