package com.gustavo.desafio_android.ui.main.recyclerview.pullrequest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.desafio_android.databinding.PullRequestBinding
import com.gustavo.desafio_android.model.PullRequest
import com.gustavo.desafio_android.ui.main.activity.interf.OpenUrlInterf
import com.gustavo.desafio_android.ui.main.recyclerview.pullrequest.viewholder.PullRequestListViewHolder

class PullRequestListAdapter : RecyclerView.Adapter<PullRequestListViewHolder>() {

    private var pullRequestList = arrayListOf<PullRequest>()

    fun addAll(pullRequestListOfValues: List<PullRequest>){
        pullRequestList.addAll(pullRequestListOfValues)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestListViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var pullRequestBinding = PullRequestBinding.inflate(layoutInflater, parent, false)
        return PullRequestListViewHolder(pullRequestBinding)
    }

    override fun onBindViewHolder(holder: PullRequestListViewHolder, position: Int) {
        val repository = pullRequestList[position]
        holder.bind(repository)
    }

    override fun getItemCount(): Int {
        return pullRequestList.size
    }


}


