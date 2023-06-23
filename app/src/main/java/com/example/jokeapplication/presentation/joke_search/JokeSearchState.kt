package com.example.jokeapplication.presentation.joke_search

import com.example.jokeapplication.domain.model.Joke

data class JokeSearchState(
    val data:Joke?=null,
    val error:String = "",
    val isLoading:Boolean = false
) {

}