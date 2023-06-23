package com.example.jokeapplication.data.remote

import com.example.jokeapplication.data.model.JokesDTO
import retrofit2.http.GET

interface JokeSearchAPI {

    @GET("api?format=json")
    suspend fun getJoke():JokesDTO
}