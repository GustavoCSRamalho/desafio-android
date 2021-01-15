package com.gustavo.desafio_android.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(@SerializedName("avatar_url") var url:String = "", @SerializedName("login") var userName:String = ""):Parcelable
