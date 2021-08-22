package com.example.chucknorrisjokesfun.services

import com.example.chucknorrisjokesfun.const.BASE_URL2
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val api: JokeServiceAPI by lazy {
        retrofit.create(JokeServiceAPI::class.java)
    }

}