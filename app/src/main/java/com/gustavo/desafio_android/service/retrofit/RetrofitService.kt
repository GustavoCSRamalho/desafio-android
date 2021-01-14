package com.gustavo.desafio_android.service.retrofit

import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.service.retrofit.interf.RetrofitInterface
import io.reactivex.Observable
import io.reactivex.Single

class RetrofitService(var retrofit: Retrofit) {

    fun getRepositoryList(pageNumber:String): Single<Repositories> {
        return retrofit.getRetrofitInterface().getRepositoryListFromGitHub(pageNumber)
    }
}