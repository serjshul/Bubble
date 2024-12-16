package com.serjshul.bubble.services

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

class LogService @Inject constructor() {
    fun logNonFatalCrash(throwable: Throwable) =
        Log.e(TAG, throwable.toString())
}