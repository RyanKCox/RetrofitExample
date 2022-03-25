package com.revature.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class Toy(

    @SerializedName("toyid")
    val id:Int,
    @SerializedName("name")
    val sName:String,
    @SerializedName("description")
    val sDescription:String,
    @SerializedName("posterId")
    val posterId:Int,
    @SerializedName("img")
    val sImagePath:String)