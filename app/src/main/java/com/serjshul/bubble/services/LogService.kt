package com.serjshul.bubble.services

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

class LogService @Inject constructor() {
    fun logNonFatalCrash(throwable: Throwable) = Log.e(TAG, throwable.toString())

    fun logDataException(throwable: Throwable) = Log.e(TAG, throwable.toString())

    fun logRemoteDataSourceException(throwable: Throwable) = Log.e(TAG, throwable.toString())

    fun logDataSetting(
        source: String,
        type: String,
        id: String
    ) = Log.v(TAG, "$source: data setting the $type (ID: $id)")

    fun logDataExistence(
        source: String,
        type: String,
        id: String,
        isExist: Boolean
    ) = Log.v(TAG, "$source: the $type (ID: $id) ${if (isExist) "already exists" else "doesn't exist"}")
}