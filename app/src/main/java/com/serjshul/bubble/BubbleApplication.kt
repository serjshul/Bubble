package com.serjshul.bubble

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BubbleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // TODO: if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }
}