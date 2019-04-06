package com.javaxian.applications.buildingservicesapp.data.network

import EndPointConf
import com.javaxian.applications.buildingservicesapp.data.network.response.ResponseInfoPayments
import io.reactivex.Observable
import retrofit2.http.GET

interface IWebServices {

    @GET(EndPointConf.GET_INFO_PAYMENTS)
    fun getInfoPayments(): Observable<ResponseInfoPayments>
}