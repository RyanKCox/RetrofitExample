package com.revature.retrofitexample.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.retrofitexample.network.RequestToys
import com.revature.retrofitexample.network.ToyList
import com.revature.retrofitexample.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BrowseToysViewModel(): ViewModel() {

    val toysListResponse = MutableLiveData<ToyList>()

    var toyList by mutableStateOf(ToyList(listOf()))

    //val toyList:ToyList by mutableStateOf()


    init {
        getAllToys()
    }

    private fun getAllToys(){

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val toyService = RetrofitHelper.getToysService()

                val responseService =
                    toyService.getToys(RequestToys(
                        "Toys",
                        "all"))

                if (responseService.isSuccessful){

                    responseService.body()?.let {
                        toysListResponse.value = it
                        toyList = toysListResponse.value?:ToyList(listOf())

                        Log.d("Fetch Toys Success", toysListResponse.toString())
                    }
                } else {
                    responseService.errorBody()?.let {
                        Log.d("Fetch Toys Failed", it.string())
                        it.close()
                    }

                }

            }catch (e:Exception){
                Log.d("Error Fetching", e.toString())

            }
        }
    }
}