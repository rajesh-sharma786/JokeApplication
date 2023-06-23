package com.example.jokeapplication.di

import com.example.jokeapplication.ApiCall.JokeSearchApi
import org.koin.dsl.module

val apiModule = module {
    factory { JokeSearchApi() }
}