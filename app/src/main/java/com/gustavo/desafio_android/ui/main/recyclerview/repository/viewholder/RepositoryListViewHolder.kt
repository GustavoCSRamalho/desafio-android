package com.gustavo.desafio_android.ui.main.recyclerview.repository.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gustavo.desafio_android.R
import com.gustavo.desafio_android.databinding.RepositoryBinding
import com.gustavo.desafio_android.model.Repository
import com.gustavo.desafio_android.ui.main.activity.interf.ChangePageInterf

class RepositoryListViewHolder(
    var repositoryBindingRef: RepositoryBinding
) : RecyclerView.ViewHolder(repositoryBindingRef.root) {

    fun bind(repository: Repository) {
        repositoryBindingRef.repository = repository

        Glide.with(repositoryBindingRef.root)
            .load(repository.user.url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .circleCrop()
            .into(repositoryBindingRef.repositoryUserImage)


        repositoryBindingRef.root.setOnClickListener {
            (repositoryBindingRef.root.context as ChangePageInterf<Repository>).changePage(R.id.pullRequestListFragment, repository)
        }
    }

}