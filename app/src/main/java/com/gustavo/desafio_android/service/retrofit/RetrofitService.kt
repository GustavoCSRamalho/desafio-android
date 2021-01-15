package com.gustavo.desafio_android.service.retrofit

import com.gustavo.desafio_android.model.PullRequest
import com.gustavo.desafio_android.model.PullRequests
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.service.retrofit.interf.RetrofitInterface
import io.reactivex.Observable
import io.reactivex.Single

class RetrofitService(var retrofit: Retrofit) {

    fun getRepositoryList(pageNumber:String): Single<Repositories> {
        return retrofit.getRetrofitInterface().getRepositoryListFromGitHub(pageNumber)
    }

    fun getPullRequestList(repository: Repository): Single<List<PullRequest>> {
        return retrofit.getRetrofitInterface().getPullRequestListFromGitHub(repository.user.userName,repository.name)
    }
}