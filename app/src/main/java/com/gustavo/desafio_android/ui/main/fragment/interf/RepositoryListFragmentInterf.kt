package com.gustavo.desafio_android.ui.main.fragment.interf

import android.view.View
import androidx.paging.PagingData
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository

interface RepositoryListFragmentInterf {

    fun updateAdapter(repositoriesPagingData: PagingData<Repository>)


}