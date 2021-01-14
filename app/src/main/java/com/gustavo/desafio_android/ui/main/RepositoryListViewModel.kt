package com.gustavo.desafio_android.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.rxjava2.cachedIn
import androidx.paging.rxjava2.flowable
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.service.pagination.RepositoryListPaginationDataSource
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import com.gustavo.desafio_android.ui.main.fragment.RepositoryListFragmentInterf
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow

class RepositoryListViewModel(var retrofitService: RetrofitService) : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var repositoryListFragment: RepositoryListFragmentInterf

    val repositoryList: Flowable<PagingData<Repository>> = Pager(PagingConfig(30)) {
        RepositoryListPaginationDataSource(retrofitService)
    }.flowable.cachedIn(viewModelScope)

    fun setUIReference(fragmentRefence: RepositoryListFragmentInterf) {
        this.repositoryListFragment = fragmentRefence
    }
}