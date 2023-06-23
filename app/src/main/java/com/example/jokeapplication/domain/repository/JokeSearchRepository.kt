package com.example.jokeapplication.domain.repository

import com.example.jokeapplication.common.Component
import com.example.jokeapplication.data.model.JokesDTO

interface JokeSearchRepository {
    suspend fun getJoke():JokesDTO
}

class JokeSearchRepositoryImpl:JokeSearchRepository{
    val component = Component()
    override suspend fun getJoke(): JokesDTO {
        return component.getJokeImpl.getJoke()
    }
}