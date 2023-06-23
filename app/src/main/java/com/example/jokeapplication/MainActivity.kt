package com.example.jokeapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jokeapplication.common.Component
import com.example.jokeapplication.databinding.ActivityMainBinding
import com.example.jokeapplication.presentation.joke_search.JokeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.first_fragment, JokeFragment())
            .commitAllowingStateLoss()
        manager.executePendingTransactions()

    }

}