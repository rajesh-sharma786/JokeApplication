package com.example.jokeapplication.ApiCall

import com.example.jokeapplication.common.Constants
import com.example.jokeapplication.data.remote.JokeSearchAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeSearchApi {
    fun getJokeSearchApiService(): JokeSearchAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(JokeSearchAPI::class.java)
    }
}