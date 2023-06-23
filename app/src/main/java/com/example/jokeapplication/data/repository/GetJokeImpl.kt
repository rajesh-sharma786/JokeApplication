package com.example.jokeapplication.data.repository

import com.example.jokeapplication.common.Component
import com.example.jokeapplication.data.model.JokesDTO
import com.example.jokeapplication.data.remote.JokeSearchAPI
import com.example.jokeapplication.domain.repository.JokeSearchRepository

class GetJokeImpl(): JokeSearchRepository {
    val component = Component()
    override suspend fun getJoke(): JokesDTO {
        return component.jokeSearchApi.getJokeSearchApiService().getJoke()
    }
}