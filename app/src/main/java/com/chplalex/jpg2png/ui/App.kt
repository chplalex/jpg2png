package com.chplalex.jpg2png.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    private val cicerone: Cicerone<Router>by lazy {
        Cicerone.create()
    }

    val navigatorHolder
        get() = cicerone.navigatorHolder

    val router
        get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}