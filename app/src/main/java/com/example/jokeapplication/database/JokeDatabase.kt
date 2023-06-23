package com.example.jokeapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jokeapplication.dao.JokeEntityDAO
import com.example.jokeapplication.data.model.JokeEntity

@Database(entities = [JokeEntity::class], version = 1)
abstract class JokeDatabase : RoomDatabase() {

    abstract fun jokeEntityDao() : JokeEntityDAO

    companion object{
        @Volatile
        private var INSTANCE : JokeDatabase ?= null

        fun getDatabase(context: Context): JokeDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        JokeDatabase::class.java,
                        "jokeDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}