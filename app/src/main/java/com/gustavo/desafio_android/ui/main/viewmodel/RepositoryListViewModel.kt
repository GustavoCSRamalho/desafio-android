package com.gustavo.desafio_android.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import androidx.paging.rxjava2.flowable
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.service.pagination.RepositoryListPaginationDataSource
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import com.gustavo.desafio_android.ui.main.fragment.interf.RepositoryListFragmentInterf
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class RepositoryListViewModel(var retrofitService: RetrofitService) : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var repositoryListFragment: RepositoryListFragmentInterf

    val repositoryList: Flowable<PagingData<Repository>> = Pager(PagingConfig(30)) {
        RepositoryListPaginationDataSource(retrofitService)
    }.flowable.cachedIn(viewModelScope)

    fun setUIReference(fragmentRefence: RepositoryListFragmentInterf) {
        this.repositoryListFragment = fragmentRefence
    }

    fun updateAdapter(){
        repositoryList
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
               repositoryListFragment.updateAdapter(it)
            }
    }
}