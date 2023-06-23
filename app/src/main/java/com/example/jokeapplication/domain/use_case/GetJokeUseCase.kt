package com.example.jokeapplication.domain.use_case

import com.example.jokeapplication.common.Component
import com.example.jokeapplication.common.Resource
import com.example.jokeapplication.domain.model.Joke
import com.example.jokeapplication.domain.repository.JokeSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class GetJokeUseCase () {

    val component = Component()
    operator fun invoke(): Flow<Resource<Joke>> = flow{
        try{

          emit(Resource.Loading())

          val response = component.jokeSearchRepository.getJoke()
          val joke = response.joke  ?: ""
          emit(Resource.Success(Joke(joke)))

        }
        catch (e:HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown error"))
        }
        catch (e:IOException){
            emit(Resource.Error(message = e.localizedMessage ?: "Check your internet connection"))
        }
        catch (e:Exception){

        }
    }
}