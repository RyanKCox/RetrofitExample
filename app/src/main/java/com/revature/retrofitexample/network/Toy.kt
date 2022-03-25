package com.revature.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class Toy(

    @SerializedName("id")
    val id:Int,
    @SerializedName("sName")
    val sName:String,
    @SerializedName("sDescription")
    val sDescription:String,
    @SerializedName("posterId")
    val posterId:Int,
    @SerializedName("sImagePath")
    val sImagePath:String)