package com.gustavo.desafio_android.ui.main.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.gustavo.desafio_android.R
import com.gustavo.desafio_android.databinding.PullRequestListBinding
import com.gustavo.desafio_android.model.PullRequest
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.ui.main.fragment.interf.PullRequestListFragmentInterf
import com.gustavo.desafio_android.ui.main.recyclerview.pullrequest.adapter.PullRequestListAdapter
import com.gustavo.desafio_android.ui.main.viewmodel.PullRequestListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PullRequestListFragment : Fragment(R.layout.pull_request_list), PullRequestListFragmentInterf {

    private val args by navArgs<PullRequestListFragmentArgs>()

    private val pullRequestListViewModel by viewModel<PullRequestListViewModel>()

    private val pullRequestListAdapter by inject<PullRequestListAdapter>()

    private lateinit var pullRequestListBinding: PullRequestListBinding

    private lateinit var recyclerViewRepository: RecyclerView

    private lateinit var repository: Repository

    private lateinit var navHostFragment: NavHostFragment

    private lateinit var navController: NavController



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRepositoryFromArgs()

        initVariables(view)

        setFragmentLabel()

        setup()

    }

    private fun setup() {
        recyclerViewRepository = pullRequestListBinding.recyclerviewPullRequest
        recyclerViewRepository.adapter = pullRequestListAdapter
        pullRequestListViewModel.setUIReference(this)
        pullRequestListViewModel.pullRequestList(repository)
    }

    private fun setFragmentLabel() {
        navController.currentDestination!!.label = "Testando"
    }

    private fun initVariables(view: View) {
        navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.main_activity_nav_host) as NavHostFragment
        navController = navHostFragment.navController
        pullRequestListBinding = PullRequestListBinding.bind(view)
    }

    private fun getRepositoryFromArgs() {
        repository = args.repository
    }

    override fun updateAdapter(listOfPullRequests: List<PullRequest>) {
        pullRequestListAdapter.addAll(listOfPullRequests)
    }

}