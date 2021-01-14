package com.gustavo.desafio_android.ui.main.fragment

import com.gustavo.desafio_android.model.Repositories

interface RepositoryListFragmentInterf {

    fun updateAdapter(repositories: Repositories)
}