package com.gustavo.desafio_android.ui.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.gustavo.desafio_android.R
import com.gustavo.desafio_android.databinding.RepositoryListBinding
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.ui.main.fragment.interf.RepositoryListFragmentInterf
import com.gustavo.desafio_android.ui.main.viewmodel.RepositoryListViewModel
import com.gustavo.desafio_android.ui.main.recyclerview.repository.adapter.RepositoryListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryListFragment : Fragment(R.layout.repository_list), RepositoryListFragmentInterf {

    private val repositoryListViewModel by viewModel<RepositoryListViewModel>()

    private val repositoryListAdapter by inject<RepositoryListAdapter>()

    private lateinit var repositoryListBinding:RepositoryListBinding

    private lateinit var recyclerViewRepository: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables(view)

        setup()
        updateAdapter()

    }

    private fun setup() {
        recyclerViewRepository = repositoryListBinding.recyclerviewRepository
        recyclerViewRepository.adapter = repositoryListAdapter
        repositoryListViewModel.setUIReference(this)
    }

    private fun initVariables(view: View) {
        repositoryListBinding = RepositoryListBinding.bind(view)
    }

    private fun updateAdapter() {
        repositoryListViewModel.updateAdapter()
    }

    override fun updateAdapter(repositoriesPagingData: PagingData<Repository>) {
        viewLifecycleOwner.lifecycleScope.launch {
            repositoryListAdapter.submitData(repositoriesPagingData)
        }

    }

}