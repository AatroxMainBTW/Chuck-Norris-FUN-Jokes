package com.example.chucknorrisjokesfun.repository

import com.example.chucknorrisjokesfun.models.Joke
import com.example.chucknorrisjokesfun.services.RetrofitInstance

class Repository {
    suspend fun getJokesFromAPI():Joke{
       return RetrofitInstance.api.getJokesFromAPI()
    }
}