package com.gustavo.desafio_android.service.retrofit

import com.gustavo.desafio_android.service.retrofit.interf.RetrofitInterface
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    private var retrofit: Retrofit? = null

    init {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .client(OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }

    private fun getRetrofit(): Retrofit? {
        return retrofit
    }

    fun getRetrofitInterface(): RetrofitInterface {
        return getRetrofit()!!.create(
            RetrofitInterface::class.java
        )
    }

}