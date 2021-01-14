package com.gustavo.desafio_android.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue

data class Repositories(@SerializedName("items") var itens: List<Repository> = listOf())
