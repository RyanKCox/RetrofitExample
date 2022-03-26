package com.revature.retrofitexample.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.retrofitexample.network.RequestToys
import com.revature.retrofitexample.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.resolveDefaults
import com.revature.retrofitexample.network.Toy
import com.revature.retrofitexample.network.repository.ToyRepository

class BrowseToysViewModel(): ViewModel() {

    private val toyService = RetrofitHelper.getToysService()

    private lateinit var toyRepo:ToyRepository

    var allToys:List<Toy> by mutableStateOf(listOf())

    init {
        getAllToys()

    }

    private fun getAllToys() {
        toyRepo = ToyRepository((toyService))

        viewModelScope.launch {

            var response = toyRepo.fetchAllToys()

            when (response) {

                is ToyRepository.Result.Success-> {
                    Log.d("ViewModel", "Load Successful")
                    allToys = response.toyList
                }
                is ToyRepository.Result.Failure-> {
                    Log.d("ViewModel", "Load Failed")
                }
            }
        }
    }
}