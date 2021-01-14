package com.gustavo.desafio_android.ui.main.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.desafio_android.databinding.RepositoryBinding
import com.gustavo.desafio_android.model.Repositories
import com.gustavo.desafio_android.model.Repository

public class RepositoryListAdapter : RecyclerView.Adapter<RepositoryListAdapter.MovieViewHolder>() {

    private var repositoryList = arrayListOf<Repository>()

    fun add(repository: Repository){
        repositoryList.add(repository)
        notifyDataSetChanged()
    }

    fun addAll(repositories: Repositories){
        repositoryList.addAll(repositories.itens)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var repositoryListBinding = RepositoryBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(repositoryListBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val repository = repositoryList[position]
        holder.bind(repository)
    }

    override fun getItemCount() = repositoryList.size


    class MovieViewHolder(var repositoryBindingRef: RepositoryBinding) : RecyclerView.ViewHolder(repositoryBindingRef.root) {

        fun bind(repository: Repository) {
            repositoryBindingRef.repository = repository

            Glide.with(repositoryBindingRef.root)
                .load(repository.user.url)
                .circleCrop()
                .into(repositoryBindingRef.repositoryUserImage)
//            repositoryBindingRef.repositoryName.text = repository.name
            Log.i("Name",repository.name)
        }

        private var repositoryListBinding = repositoryBindingRef

    }
}


