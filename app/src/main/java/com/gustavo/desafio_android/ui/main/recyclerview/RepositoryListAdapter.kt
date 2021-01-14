package com.gustavo.desafio_android.ui.main.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.desafio_android.databinding.RepositoryBinding
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository

class RepositoryListAdapter : PagingDataAdapter<Repository, RepositoryListAdapter.RepositoryListViewHolder>(RepositoryListComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var repositoryListBinding = RepositoryBinding.inflate(layoutInflater, parent, false)
        return RepositoryListViewHolder(repositoryListBinding)
    }

    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        val repository = getItem(position)!!
        holder.bind(repository)
    }


object RepositoryListComparator : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem == newItem
    }

}

    class RepositoryListViewHolder(var repositoryBindingRef: RepositoryBinding) : RecyclerView.ViewHolder(repositoryBindingRef.root) {

        fun bind(repository: Repository) {
            repositoryBindingRef.repository = repository

            Glide.with(repositoryBindingRef.root)
                .load(repository.user.url)
                .circleCrop()
                .into(repositoryBindingRef.repositoryUserImage)
        }
    }
}


