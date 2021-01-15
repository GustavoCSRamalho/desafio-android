package com.gustavo.desafio_android.model

import com.google.gson.annotations.SerializedName

data class PullRequest(@SerializedName("title") var title:String = "",
                       @SerializedName("updated_at") var data:String= "",
                       @SerializedName("full_name") var fullName: String = "",
                       @SerializedName("body") var body: String= "",
                       @SerializedName("head") var head: Head = Head(),
                       @SerializedName("html_url") var urlPullRequest: String= "")
