package com.gustavo.desafio_android.service.pagination

import android.util.Log
import androidx.paging.rxjava2.RxPagingSource
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryListPaginationDataSource(val retrofitService: RetrofitService):
    RxPagingSource<Int, Repository>() {
    var count = 1;
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Repository>> {
        val position = params.key ?: 1
        Log.i("Acessei site","${count}")
        count++
        return retrofitService.getRepositoryList(position.toString())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread()).map {
                toLoadResult(it,position)
            }

    }

    private fun toLoadResult(data: Repositories, position: Int): LoadResult<Int,Repository> {
        return LoadResult.Page(
            data = data.itens,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position >= 1) position.plus(1) else null
        )
    }

//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
//        try {
//            // Start refresh at page 1 if undefined.
//            val nextPage = params.key ?: 1
//            val response: Repositories = retrofitService.getRepositoryList(nextPage.toString())
//                    .subscribeOn(Schedulers.newThread())
//                    .observeOn(AndroidSchedulers.mainThread()).blockingFirst()
//            return LoadResult.Page(
//                data = response.itens,
//                prevKey = if (nextPage == 1) null else nextPage - 1,
//                nextKey = nextPage.plus(1)
//            )
//
//        } catch (e: Exception) {
//            return LoadResult.Error(e)
//        }
//    }



}