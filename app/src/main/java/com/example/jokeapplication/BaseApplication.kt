package com.example.jokeapplication

import android.app.Application
import com.example.jokeapplication.di.apiModule
import com.example.jokeapplication.di.classModule
import com.example.jokeapplication.di.interfaceModule
import org.koin.core.context.startKoin

class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(interfaceModule, apiModule, classModule)
        }
    }
}