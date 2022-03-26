package com.revature.retrofitexample.network.repository

import android.util.Log
import com.revature.retrofitexample.network.RequestToys
import com.revature.retrofitexample.network.Toy

class ToyRepository(val toyServiceApi:ToysApiService) {

    sealed class Result{
        object Loading:Result()
        data class Success(val toyList:List<Toy>):Result()
        data class Failure(val throwable:Throwable):Result()
    }

    suspend fun fetchAllToys():Result{

        return try {

            val toyList = toyServiceApi.getToys(RequestToys(
                "Toys",
                "all")).results

            Log.d("ToyList", "Success " + toyList.size)
            Result.Success(toyList)

        } catch (e:Exception){
            Log.d("ToyList", "Failed")
            Result.Failure(e)

        }
    }

}