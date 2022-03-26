package com.revature.retrofitexample.network

import com.google.gson.annotations.SerializedName

data class ToyResponse (

    @SerializedName("toys")
    var results:ArrayList<Toy>

        )