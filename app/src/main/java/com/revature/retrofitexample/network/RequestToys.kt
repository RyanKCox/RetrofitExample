package com.revature.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class RequestToys(

    @SerializedName("sToyTable")
    val sToyTable:String,
    @SerializedName("sScope")
    val sScope:String
)