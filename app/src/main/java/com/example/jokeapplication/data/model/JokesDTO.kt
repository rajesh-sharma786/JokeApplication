package com.example.jokeapplication.data.model

import com.example.jokeapplication.domain.model.Joke

data class JokesDTO(
    val joke: String?
)

fun JokesDTO.toDomainJoke():Joke{
    return Joke(
        joke = this.joke ?: ""
    )
}