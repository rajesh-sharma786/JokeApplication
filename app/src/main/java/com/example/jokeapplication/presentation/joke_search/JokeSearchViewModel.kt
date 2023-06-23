package com.example.jokeapplication.presentation.joke_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokeapplication.common.Component
import com.example.jokeapplication.common.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class JokeSearchViewModel()
    : ViewModel() {
        val component = Component()
        private val _jokeData = MutableStateFlow<JokeSearchState>(JokeSearchState())
        val jokeData:StateFlow<JokeSearchState> = _jokeData

    fun jokeData(){
        component.jokeUseCase.invoke().onEach {
            when(it){
                is Resource.Loading ->{
                    _jokeData.value = JokeSearchState(isLoading = true)
                }
                is Resource.Error->{
                    _jokeData.value = JokeSearchState(error = it.message?:"")
                }
                is Resource.Success->{
                    _jokeData.value = JokeSearchState(it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}