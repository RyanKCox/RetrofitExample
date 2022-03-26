package com.revature.retrofitexample.network.repository

import com.revature.retrofitexample.network.RequestToys
import com.revature.retrofitexample.network.Toy
import com.revature.retrofitexample.network.ToyResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ToysApiService {

    @POST("alltoys")
    suspend fun getToys(@Body RequestToys: RequestToys)
        :ToyResponse
}