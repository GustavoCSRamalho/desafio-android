package com.gustavo.desafio_android.ui.main.recyclerview.repository.comparator

import androidx.recyclerview.widget.DiffUtil
import com.gustavo.desafio_android.model.Repository

object RepositoryListComparator : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem == newItem
    }

}