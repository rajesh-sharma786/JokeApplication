package com.example.jokeapplication.di

import com.example.jokeapplication.ApiCall.JokeSearchApi
import com.example.jokeapplication.domain.use_case.GetJokeUseCase
import org.koin.dsl.module

val classModule = module {
    factory { GetJokeUseCase() }
}