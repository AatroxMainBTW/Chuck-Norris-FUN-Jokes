package com.example.chucknorrisjokesfun.services

import com.example.chucknorrisjokesfun.models.Joke
import retrofit2.http.GET

interface JokeServiceAPI {

    @GET("jokes/random")
    suspend fun getJokesFromAPI():Joke
}