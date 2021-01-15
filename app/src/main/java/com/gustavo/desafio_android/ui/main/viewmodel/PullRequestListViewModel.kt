package com.gustavo.desafio_android.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import com.gustavo.desafio_android.ui.main.fragment.interf.PullRequestListFragmentInterf
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PullRequestListViewModel(var retrofitService: RetrofitService) : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var repositoryListFragment: PullRequestListFragmentInterf


    fun setUIReference(fragmentRefence: PullRequestListFragmentInterf) {
        this.repositoryListFragment = fragmentRefence
    }

    fun pullRequestList(repository: Repository){
        retrofitService.getPullRequestList(repository)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { listOfPullRequests ->
                repositoryListFragment.updateAdapter(listOfPullRequests)
            }
    }
}