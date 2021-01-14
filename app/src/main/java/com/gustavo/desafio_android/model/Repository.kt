package com.gustavo.desafio_android.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue

data class Repository(@SerializedName("name") var name:String = "",
                      @SerializedName("id") var id:String = "",
                      @SerializedName("description")var description: String = "",
                      @SerializedName("full_name") var fullName: String = "",
                      @SerializedName("stargazers_count") var startCount: String = "",
                      @SerializedName("forks_count") var forkCount: String = "",
                      @SerializedName("owner") var user: @RawValue User = User())
