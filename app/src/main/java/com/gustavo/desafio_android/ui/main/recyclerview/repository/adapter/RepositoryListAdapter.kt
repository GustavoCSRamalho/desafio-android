package com.gustavo.desafio_android.ui.main.recyclerview.repository.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.desafio_android.R
import com.gustavo.desafio_android.databinding.RepositoryBinding
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.ui.main.activity.interf.ChangePageInterf
import com.gustavo.desafio_android.ui.main.fragment.interf.RepositoryListFragmentInterf
import com.gustavo.desafio_android.ui.main.recyclerview.repository.comparator.RepositoryListComparator
import com.gustavo.desafio_android.ui.main.recyclerview.repository.viewholder.RepositoryListViewHolder

class RepositoryListAdapter : PagingDataAdapter<Repository, RepositoryListViewHolder>(
    RepositoryListComparator
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var repositoryListBinding = RepositoryBinding.inflate(layoutInflater, parent, false)
        return RepositoryListViewHolder(repositoryListBinding)
    }

    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        val repository = getItem(position)!!
        holder.bind(repository)
    }
}


