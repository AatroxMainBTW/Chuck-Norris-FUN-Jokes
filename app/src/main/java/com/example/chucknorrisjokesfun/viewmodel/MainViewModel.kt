package com.example.chucknorrisjokesfun.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisjokesfun.models.Joke
import com.example.chucknorrisjokesfun.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Joke> = MutableLiveData()

    fun getJokesFromAPI() {
        viewModelScope.launch {
            val response:Joke = repository.getJokesFromAPI()
            myResponse.value = response
        }
    }
}