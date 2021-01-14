package com.gustavo.desafio_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustavo.desafio_android.service.retrofit.Retrofit
import com.gustavo.desafio_android.service.retrofit.RetrofitService
import com.gustavo.desafio_android.ui.main.RepositoryListViewModel
import com.gustavo.desafio_android.ui.main.recyclerview.RepositoryListAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, MainFragment.newInstance())
//                    .commitNow()
//        }

        startKoin {
            androidContext(this@MainActivity)
//            modules(listOf(singleton,factory,viewModel))
            modules(listOf(module {
                viewModel {
                    RepositoryListViewModel(get())
                }
                factory{
                    RepositoryListAdapter()
                }
                factory{
                    RetrofitService(get())
                }
                single {
                    Retrofit()
                }

            }))
        }
    }



//    var viewModel = module {
//        viewModel {
//            RepositoryListViewModel(get())
//        }
//    }
//
//    var factory = module {
//        factory{
//            RepositoryListAdapter()
//            RetrofitService(get())
//        }
//    }
//
//    var singleton = module {
//        single {
//            Retrofit()
//        }
//    }
}