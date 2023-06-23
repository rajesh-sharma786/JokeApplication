package com.example.jokeapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jokeapplication.data.model.JokeEntity

@Dao
interface JokeEntityDAO {
    @Insert
    suspend fun insertJoke(jokeEntity: JokeEntity)

    @Update
    suspend fun updateJoke(jokeEntity: JokeEntity)

    @Query("DELETE FROM jokeEntity where id in (SELECT id FROM jokeEntity limit 1)")
    suspend fun deleteJoke()

    @Query("SELECT * FROM jokeEntity LIMIT 10")
    fun getJokes(): LiveData<List<JokeEntity>>

}