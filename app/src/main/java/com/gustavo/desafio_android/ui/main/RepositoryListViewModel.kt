package com.gustavo.desafio_android.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import com.gustavo.desafio_android.ui.main.fragment.RepositoryListFragmentInterf
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryListViewModel(var retrofitService: RetrofitService) : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var repositoryListFragment: RepositoryListFragmentInterf

    fun setUIReference(fragmentRefence: RepositoryListFragmentInterf) {
        this.repositoryListFragment = fragmentRefence
    }


    fun updateRepositoryList() {
        retrofitService.getRepositoryList("1")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                Log.i("Itens",it.toString())
                repositoryListFragment.updateAdapter(it)
            })
    }
}