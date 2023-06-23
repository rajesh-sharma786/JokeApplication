package com.example.jokeapplication.common

import com.example.jokeapplication.ApiCall.JokeSearchApi
import com.example.jokeapplication.data.repository.GetJokeImpl
import com.example.jokeapplication.domain.repository.JokeSearchRepositoryImpl
import com.example.jokeapplication.domain.use_case.GetJokeUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class Component:KoinComponent {
    val getJokeImpl:GetJokeImpl by inject()
    val jokeSearchApi:JokeSearchApi by inject()
    val jokeSearchRepository:JokeSearchRepositoryImpl by inject()
    val jokeUseCase:GetJokeUseCase by inject()
}