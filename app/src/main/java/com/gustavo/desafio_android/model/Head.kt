package com.gustavo.desafio_android.model

import com.google.gson.annotations.SerializedName

data class Head(@SerializedName("user")var user: User = User())
