package com.example.movies2look4.application

import android.app.Application
import com.example.movies2look4.di.components.AppComponent
import com.example.movies2look4.di.components.DaggerAppComponent
import com.example.movies2look4.di.modules.AppModule
import com.example.movies2look4.di.modules.NetModule

class MyApplication: Application() {

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: MyApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .netModule(NetModule())
            .build()
}

