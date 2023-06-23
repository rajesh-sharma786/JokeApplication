package com.example.jokeapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokeEntity")
data class JokeEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val joke : String
)