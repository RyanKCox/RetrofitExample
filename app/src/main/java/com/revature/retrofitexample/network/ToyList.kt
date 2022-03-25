package com.revature.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class ToyList (

    @SerializedName("toys")
    var results:List<Toy>

        )