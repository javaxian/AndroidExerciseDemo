package com.javaxian.applications.buildingservicesapp.domain.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {

    private var retrofit: Retrofit

    init{
        retrofit = Retrofit.Builder()
                .baseUrl(EndPointConf.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(getGsonConverter()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();

    }

    private fun getGsonConverter(): Gson {
        val builder = GsonBuilder()
        builder.excludeFieldsWithoutExposeAnnotation()

        val gson = builder.create()
        return gson
    }

    private fun getOkHttpClient():OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okhttpclient = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return okhttpclient
    }

    @Provides
    @Singleton
    fun getRetrofitClient():Retrofit{
        return retrofit
    }
}