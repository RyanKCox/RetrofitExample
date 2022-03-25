package com.revature.retrofitexample.network.repository

import com.revature.retrofitexample.network.RequestToys
import com.revature.retrofitexample.network.Toy
import com.revature.retrofitexample.network.ToyList
import retrofit2.http.Body
import retrofit2.http.POST

interface ToysApiService {

    @POST("alltoys")
    suspend fun getToys(@Body RequestToys: RequestToys)
        :retrofit2.Response<ToyList>
}