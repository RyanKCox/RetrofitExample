package com.revature.retrofitexample.network.repository

import com.revature.retrofitexample.network.RetrieveToys
import com.revature.retrofitexample.network.Toy
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ToysApiService {

    @POST("alltoys")
    suspend fun getToys(@Body RetrieveToys: RetrieveToys)
        :retrofit2.Response<List<Toy>>
}