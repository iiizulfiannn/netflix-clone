package com.luckyfriday.netflixclone

import android.app.Application
import com.luckyfriday.netflixclone.di.AppContainer

class MyApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}