package com.gustavo.desafio_android.service.pagination

import android.util.Log
import androidx.paging.rxjava2.RxPagingSource
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryListPaginationDataSource(private val retrofitService: RetrofitService):
    RxPagingSource<Int, Repository>() {
    var count = 1;
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Repository>> {
        val position = params.key ?: 1
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
}