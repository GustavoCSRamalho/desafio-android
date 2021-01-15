package com.gustavo.desafio_android.ui.main.application

import android.app.Application
import com.gustavo.desafio_android.service.retrofit.Retrofit
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import com.gustavo.desafio_android.ui.main.recyclerview.pullrequest.adapter.PullRequestListAdapter
import com.gustavo.desafio_android.ui.main.recyclerview.repository.adapter.RepositoryListAdapter
import com.gustavo.desafio_android.ui.main.viewmodel.PullRequestListViewModel
import com.gustavo.desafio_android.ui.main.viewmodel.RepositoryListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class Application:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    fun startKoin(){
        org.koin.core.context.startKoin {
            androidContext(this@Application)
            modules(listOf(module {
                single { Retrofit() }
                factory { PullRequestListAdapter() }
                factory { RepositoryListAdapter() }
                factory { RetrofitService(get()) }
                viewModel { RepositoryListViewModel(get()) }
                viewModel { PullRequestListViewModel(get()) }
            }))
        }
    }

}