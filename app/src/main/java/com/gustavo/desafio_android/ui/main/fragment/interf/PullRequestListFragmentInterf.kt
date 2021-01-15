package com.gustavo.desafio_android.ui.main.fragment.interf

import android.view.View
import com.gustavo.desafio_android.model.PullRequest
import com.gustavo.desafio_android.model.PullRequests
import com.gustavo.desafio_android.model.Repositories

interface PullRequestListFragmentInterf {

    fun updateAdapter(listOfPullRequests: List<PullRequest>)

//    fun changePage(): View.OnTouchListener?
}