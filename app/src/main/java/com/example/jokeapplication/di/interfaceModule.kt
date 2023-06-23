package com.example.jokeapplication.di

import com.example.jokeapplication.data.remote.JokeSearchAPI
import com.example.jokeapplication.data.repository.GetJokeImpl
import com.example.jokeapplication.domain.repository.JokeSearchRepository
import com.example.jokeapplication.domain.repository.JokeSearchRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val interfaceModule = module {
    factory { GetJokeImpl()} bind JokeSearchAPI::class
    factory { JokeSearchRepositoryImpl() } bind JokeSearchRepository::class
}