package com.serjshul.bubble.services.impl

import android.content.ContentValues.TAG
import android.util.Log
import com.serjshul.bubble.services.LogService
import javax.inject.Inject

class LogServiceImpl @Inject constructor() : LogService {
    override fun logNonFatalCrash(throwable: Throwable) =
        Log.e(TAG, throwable.toString())
}