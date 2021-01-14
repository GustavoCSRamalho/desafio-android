package com.gustavo.desafio_android.ui.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gustavo.desafio_android.R
import com.gustavo.desafio_android.databinding.RepositoryListBinding
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.ui.main.RepositoryListViewModel
import com.gustavo.desafio_android.ui.main.recyclerview.RepositoryListAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryListFragment : Fragment(R.layout.repository_list),RepositoryListFragmentInterf {

    private val repositoryListViewModel by viewModel<RepositoryListViewModel>()

    private val repositoryListAdapter by inject<RepositoryListAdapter>()

    private lateinit var repositoryListBinding:RepositoryListBinding

    private lateinit var recyclerViewRepository: RecyclerView




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repositoryListBinding = RepositoryListBinding.bind(view)

        recyclerViewRepository = repositoryListBinding.recyclerviewRepository
        recyclerViewRepository.adapter = repositoryListAdapter
        repositoryListViewModel.setUIReference(this)

        repositoryListViewModel.updateRepositoryList()

//        repositoryListAdapter.add(Repository("Gustavo"))
    }

    override fun updateAdapter(repositories: Repositories) {
        repositoryListAdapter.addAll(repositories)
    }


}