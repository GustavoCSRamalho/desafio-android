package com.gustavo.desafio_android.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("avatar_url") var url:String = "", @SerializedName("login") var userName:String = "")
