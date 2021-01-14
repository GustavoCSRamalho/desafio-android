package com.gustavo.desafio_android.service.retrofit.interf

import com.gustavo.desafio_android.model.Repositories
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/search/repositories")
    fun getRepositoryListFromGitHub(@Query("pageNumber") numberOfThePage:String,
                                    @Query("q") language:String = "language:Java",
                                    @Query("sort") sortType:String="stars"): Observable<Repositories>


}
