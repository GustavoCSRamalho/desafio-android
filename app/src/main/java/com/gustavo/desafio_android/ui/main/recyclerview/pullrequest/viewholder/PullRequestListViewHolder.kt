package com.gustavo.desafio_android.ui.main.recyclerview.pullrequest.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.desafio_android.databinding.PullRequestBinding
import com.gustavo.desafio_android.model.PullRequest
import com.gustavo.desafio_android.ui.main.activity.interf.OpenUrlInterf

class PullRequestListViewHolder(
    var pullRequestBindingRef: PullRequestBinding
) : RecyclerView.ViewHolder(pullRequestBindingRef.root) {

    @SuppressLint("ClickableViewAccessibility")
    fun bind(pullRequest: PullRequest) {

        pullRequestBindingRef.pullRequest = pullRequest

        Glide.with(pullRequestBindingRef.root)
            .load(pullRequest.head.user.url)
            .circleCrop()
            .into(pullRequestBindingRef.pullRequestUserImage)

        pullRequestBindingRef.root.setOnClickListener {
            (pullRequestBindingRef.root.context as OpenUrlInterf).openURL(pullRequest.urlPullRequest)
        }
    }

}